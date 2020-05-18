package com.chensee.thread;


/**
 * @author gaohang
 */
public class MyThread extends Thread{
    //票和所对象是共享，静态的
    private static int ticket=100;
    private static Object obj=new Object();
    private static int count=1;

    /**
     * 同步代码块，常用
     * 原因：同步代码块的锁对象是任意对象，同步方法锁是字节码文件MyThread
     */
    @Override
    public void run() {
        while (true){
            //锁对象可以是常量，字符串 final或static修饰的
            synchronized (obj){
                if(ticket>0){
                    try {
                        //线程休眠不释放锁对象
                        Thread.sleep(300);
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

    /**
     * 同步方法，锁对象是MyThread对象
     */
    /*@Override
    public void run() {
        method();
    }

    public static synchronized void method(){
        while (true){
            if(ticket>0){
                try {
                    Thread.sleep(100);//线程休眠不释放锁对象
                    System.out.println(Thread.currentThread().getName()+"正在卖第"+ticket+"张票！");
                    ticket--;
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }else{
                System.out.println("票已卖完！！！！！！");
                break;
            }
        }
    }*/

}
