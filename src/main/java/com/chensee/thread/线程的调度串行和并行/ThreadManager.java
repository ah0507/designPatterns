package com.chensee.thread.线程的调度串行和并行;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

public class ThreadManager {

    ThreadPoolExecutor threadPoolExecutor = null;

    public ThreadManager() {
        threadPoolExecutor = new ThreadPoolExecutor(5, 5,
                0L, TimeUnit.MILLISECONDS,
                new LinkedBlockingQueue<Runnable>(),null,new ThreadPoolExecutor.AbortPolicy());
    }

    public void execute(final TaskGroup taskGroup) {
        threadPoolExecutor.execute(new Runnable() {
            @Override
            public void run() {
                manage(taskGroup);
                threadPoolExecutor.shutdown();
            }
        });
    }

    private void manage(TaskGroup taskGroup) {
        if (taskGroup == null || taskGroup.getTasks() == null || taskGroup.getTasks().size() == 0) {
            return;
        }
        List<Task> tasks = taskGroup.getTasks();
        List<Task> tasks2 = new ArrayList<>();
        Iterator<Task> iterator = tasks.iterator();
        while (iterator.hasNext()) {
            Task task = iterator.next();
            if (TaskGroup.class.isAssignableFrom(task.getClass())) {
                manage(TaskGroup.class.cast(task));
            } else {
                tasks2.add(task);
            }
        }
        CountDownLatch countDownLatch = new CountDownLatch(tasks2.size());
        for (Task task : tasks2) {
            TaskCommand taskCommand = new TaskCommand(task, countDownLatch);
            threadPoolExecutor.execute(taskCommand);
        }
        try {
            countDownLatch.await();
            taskGroup.execute();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

}
