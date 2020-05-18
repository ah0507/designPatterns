package com.chensee.thread.com;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * @author ah
 * @title: synchronized 或 ReentrantLock 阻塞锁
 *  Semaphore
 * @date 2020/4/3 10:50
 */
public class Test {
    public static void main(String[] args) {
        ExecutorService service = Executors.newFixedThreadPool(100);
        AmountHandle amountHandle = new AmountHandle();
        for (int i = 0; i < 1000; i++) {
            service.execute(new AmountTask(amountHandle, 1.0));
        }
        service.shutdown();
        while (!service.isTerminated()) {
        }
        System.out.println(amountHandle.getAmount());
    }
}
