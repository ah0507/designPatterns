package com.chensee.thread.线程的调度串行和并行.a;

import java.util.concurrent.CountDownLatch;

/**
 * @author ah
 * @title: TaskCommand
 * @date 2020/3/18 10:37
 */
public class TaskCommand implements Runnable {

    private Task task;

    private CountDownLatch countDownLatch;

    public TaskCommand(Task task, CountDownLatch countDownLatch) {
        this.task = task;
        this.countDownLatch = countDownLatch;
    }

    @Override
    public void run() {
        try {
            task.execute();
            task.finish();
        } finally {
            countDownLatch.countDown();
        }
    }
}
