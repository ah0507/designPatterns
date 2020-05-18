package com.chensee.thread.pool;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

public class Pool_demo2 {
    private static ThreadPoolExecutor poolExecutor = getPoolExecutor();

    /**
     * @param payMon：支付金额
     * @param key：秘钥等
     * @param companyName：支付公司
     */
    public void pay(Double payMon, String key, String companyName) {
        poolExecutor.execute(() -> {
            System.out.println(companyName + "开始支付，支付金额为：" + payMon + "元,支付时间： " + new SimpleDateFormat("HH:mm:ss").format(new Date()));
            try {
                Thread.sleep(1000);//模拟业务时间
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println("支付成功。。。成功时间： " + new SimpleDateFormat("HH:mm:ss").format(new Date()));
        });
        poolExecutor.shutdown();
//lambda表达式，java7及以下可以写成：
//				new Runnable() {
//
//					@Override
//					public void run() {
//
//
//					}
//				};
    }

    /**
     * 创建这样一个线程池：
     * 核心线程为20，最大100；
     * 多于核心线程时，线程存货时间为1分
     * 缓存队列是有界阻塞队列，最大的缓存数为30
     *  handler: 线程池对拒绝任务的处理策略(如果最大线程+最大缓存<for循环的个数就会产生拒绝策略)
     * @return
     */
    private static ThreadPoolExecutor getPoolExecutor() {
        if (poolExecutor != null) {
            return poolExecutor;
        }
        return new ThreadPoolExecutor(20, 100, 1, TimeUnit.MINUTES, new ArrayBlockingQueue<>(30),new ThreadPoolExecutor.CallerRunsPolicy());
    }

    public static void main(String[] args) {
        String name = "wz";
        Pool_demo2 demo2 = new Pool_demo2();
        for (int i = 0; i < 16; i++) {
            demo2.pay(5.00, null, name);
        }
    }
}
