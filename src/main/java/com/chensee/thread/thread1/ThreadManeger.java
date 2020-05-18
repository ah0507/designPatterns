package com.chensee.thread.thread1;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

public class ThreadManeger {

    ThreadPoolExecutor threadPoolExecutor = null;

    public ThreadManeger() {
        threadPoolExecutor = new ThreadPoolExecutor(5, 5,
                0L, TimeUnit.MILLISECONDS,
                new LinkedBlockingQueue<Runnable>());
    }

    public void execute(TaskGroup taskGroup){
        threadPoolExecutor.execute(() -> {
            threadService(taskGroup);
            close();
        });

    }

    private void close() {
        try {
            Thread.sleep(1000);
            threadPoolExecutor.shutdown();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    private void threadService(TaskGroup taskGroup) {
        if (taskGroup == null || taskGroup.getTasks().size() == 0) {
            return;
        }
        List<Task> tasks = taskGroup.getTasks();
        List<Task> currentTasks = new ArrayList<>();
        Iterator<Task> iterator = tasks.iterator();
        while (iterator.hasNext()) {
            Task task = iterator.next();
            if (task instanceof TaskGroup) {
                this.threadService((TaskGroup) task);
            } else {
                task.init();
                currentTasks.add(task);
            }
        }
        CountDownLatch countDownLatch = new CountDownLatch(currentTasks.size());
        for (Task task : currentTasks) {
            threadPoolExecutor.execute(new TaskCommand(task, countDownLatch));
        }
        try {
            countDownLatch.await();
            taskGroup.execute();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

}
