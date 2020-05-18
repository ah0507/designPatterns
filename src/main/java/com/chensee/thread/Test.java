package com.chensee.thread;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class Test {

    public static void main(String[] args) {
        /*Thread thread1=new MyThread();
        thread1.setName("窗口一");
        Thread thread2=new MyThread();
        thread2.setName("窗口二");
        Thread thread3=new MyThread();
        thread3.setName("窗口三");
        thread1.start();
        thread2.start();
        thread3.start();*/
        MyRunnable mr=new MyRunnable("共享的锁",50);
        Thread t1=new Thread(mr);
        Thread t2=new Thread(mr);
        Thread t3=new Thread(mr);
        t1.start();
        t2.start();
        t3.start();
        DateTimeFormatter d = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
        DateTimeFormatter d2 = DateTimeFormatter.ofPattern("yyyy-MM-dd");
        LocalDateTime localDate = LocalDateTime.now();
        LocalDate localDate2 = LocalDate.now();
        System.out.println(localDate.format(d));
        System.out.println(localDate2.format(d2));
        LocalDateTime localDate3 = LocalDateTime.now();
        LocalDateTime localDateTime = localDate3.minusHours(1);
        System.out.println(localDateTime);

    }
}
