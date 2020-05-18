package com.chensee.thread.线程的调度串行和并行;

import java.util.concurrent.CountDownLatch;

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
        } finally {
            countDownLatch.countDown();
        }
    }
}
