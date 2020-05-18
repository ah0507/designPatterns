package com.chensee.thread.com;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * @author ah
 * @title: AmountHandle
 * @date 2020/4/3 10:42
 */
public class AmountHandle {

    /**
     * 金额
     */
    private double amount;

    private Lock accountLock = new ReentrantLock(false);

    public void saveAmount(double money){
        accountLock.lock();
        amount +=money;
        try {
            Thread.sleep(1);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }finally {
            accountLock.unlock();
        }

    }

    public double getAmount() {
        return amount;
    }
}
