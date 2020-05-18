package com.chensee.thread.pool;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

/**
 * 线程池会分每组5个同时(从时间上看)去处理，当然如果只有三个线程，线程池也会去处理的，
 * 而且，通过线程id可以看得出，5个线程处理完后，剩下的5个线程是复用的，不是另外创建的，
 * 这也就说明，使用线程池实际上是可以减少系统资源的消耗的。
 */
public class Pool_demo implements Runnable {

    SimpleDateFormat format = new SimpleDateFormat("HH:mm:ss");

    @Override
    public void run() {
        System.out.println("执行时间：" + format.format(new Date()) + "      线程ID：  " + Thread.currentThread().getId());
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {
        Pool_demo demo = new Pool_demo();
        //TODO
        //newFixedThreadPool 创建一个定长线程池，可控制线程最大并发数，超出的线程会在队列中等待
        ExecutorService es = Executors.newFixedThreadPool(5);//创建5个线程的线程池
        for (int i = 0; i < 15; i++) {
            es.execute(demo);//执行
        }

        //TODO
        //newCachedThreadPool创建一个可缓存线程池，如果线程池长度超过处理需要，可灵活回收空闲线程，若无可回收，则新建线程。
        // 线程池为无限大，当执行第二个任务时第一个任务已经完成，会复用执行第一个任务的线程，而不用每次新建线程
        ExecutorService cachedThreadPool = Executors.newCachedThreadPool();
        for (int i = 0; i < 15; i++) {
            cachedThreadPool.execute(demo);//执行
        }
        //TODO
        //newSingleThreadExecutor创建一个单线程化的线程池，它只会用唯一的工作线程来执行任务，保证所有任务按照指定顺序(FIFO, LIFO, 优先级)执行
        ExecutorService singleThreadExecutor = Executors.newSingleThreadExecutor();
        for (int i = 0; i < 15; i++) {
            singleThreadExecutor.execute(demo);//执行
        }


        //TODO
        //scheduleAtFixedRate()与scheduleWithFixedDelay()方法都是由对任务进行周期性的调度，但两者还是有区别的，
        // 前者是以上一个任务开始时间为起点，调度下一个任务。而后者是在上一个任务结束后，在经过一个周期执行下一个任务。

        //隔两秒执行一次，如果设置Thread.sleep(5000)则隔五秒执行一次;
        ScheduledExecutorService scheduledPool = Executors.newScheduledThreadPool(10);
        scheduledPool.scheduleAtFixedRate(()->{
            try {
                Thread.sleep(1000);
                System.out.println("执行时间："+new SimpleDateFormat("HH:mm:ss").format(new Date()));
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }, 0, 2, TimeUnit.SECONDS);

        //隔三秒执行一次，如果设置Thread.sleep(5000)则隔5+2秒执行一次;
        ScheduledExecutorService scheduledPool2 = Executors.newScheduledThreadPool(10);
        scheduledPool2.scheduleWithFixedDelay(()->{
            try {
                Thread.sleep(1000);
                System.out.println("执行时间："+new SimpleDateFormat("HH:mm:ss").format(new Date()));
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }, 0, 2, TimeUnit.SECONDS);

    }
}
