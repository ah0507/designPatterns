package com.chensee.thread.thread1;

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
            Thread.sleep(1000);
            task.execute();
            task.finish();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }finally {
            countDownLatch.countDown();
        }
    }
}
