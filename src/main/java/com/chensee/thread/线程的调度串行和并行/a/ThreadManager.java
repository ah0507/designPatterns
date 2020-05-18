package com.chensee.thread.线程的调度串行和并行.a;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

/**
 * @author ah
 * @title: ThreadManager
 * @date 2020/3/16 16:00
 */
public class ThreadManager {

    public static ThreadPoolExecutor executor;

    public ThreadManager() {
        executor = new ThreadPoolExecutor(5, 5, 0L, TimeUnit.MILLISECONDS, new LinkedBlockingQueue<>());
    }

    void execute(TaskGroup taskGroup) {
        executor.execute(() -> {
            manage(taskGroup);
            executor.shutdown();
        });
    }

    /**
     * taskGroup 总的任务是一个大的任务组
     * @param taskGroup
     */
    private void manage(TaskGroup taskGroup) {
        if (taskGroup == null || taskGroup.getTasks() == null) {
            return ;
        }
        taskGroup.init();
        List<Task> tasks = taskGroup.getTasks();
        List<Task> taskList = new ArrayList<>();
        for (Task task : tasks) {
            if (task instanceof TaskGroup) {
                manage((TaskGroup) task);
            }else{
                task.init();
                taskList.add(task);
            }
        }
        CountDownLatch countDownLatch = new CountDownLatch(taskList.size());

        for (Task task : taskList) {
            executor.execute(new TaskCommand(task,countDownLatch));
        }

        try {
            countDownLatch.await();
            taskGroup.execute();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }


}
