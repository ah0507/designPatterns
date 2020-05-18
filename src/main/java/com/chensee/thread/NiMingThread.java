package com.chensee.thread;

/**
 * 匿名内部类创建线程，只是用一次时用
 */
public class NiMingThread {
    private static int ticket=150;
    //private static String share="";
    private static int count=1;

    public static void main(String[] args) {

        new Thread(){

            @Override
            public void run() {
                while (true){
                    synchronized ("只是用一次"){
                        if(ticket>0){
                            try {
                                Thread.sleep(100);
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
        }.start();
    }
}
