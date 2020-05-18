package com.chensee.thread.com;

/**
 * @author ah
 * @title: Amount
 * @date 2020/4/3 10:40
 */
public class AmountTask implements Runnable {


    private Double money;

    private AmountHandle amountHandle;

    public AmountTask(AmountHandle amountHandle, Double money) {
        this.amountHandle = amountHandle;
        this.money = money;
    }

    @Override
    public void run() {
//        synchronized (amountHandle) {
//            amountHandle.saveAmount(money);
//        }
        amountHandle.saveAmount(money);
    }
}
