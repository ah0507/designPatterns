package com.chensee.thread;

/**
 * 共享的资源可以不用static修饰，用构造器生成
 */
public class MyRunnable implements Runnable {

    private int ticket;
    private String share;
    private static int count=1;

    public MyRunnable(String share,int ticket) {
        this.share = share;
        this.ticket = ticket;
    }

    @Override
    public void run() {
        while (true){
            synchronized (share){
                if(ticket>0){
                    try {
                        Thread.sleep(1000);
                        System.out.println(Thread.currentThread().getName()+"正在卖第"+ticket+"张票！");
                        ticket--;
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }else{
                    if(count==1){
                        System.out.println("票已卖完！！！！！！");
                    }
                    count++;
                    break;
                }
            }
        }
    }
}
