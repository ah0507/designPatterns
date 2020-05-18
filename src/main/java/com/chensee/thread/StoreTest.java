package com.chensee.thread;

public class StoreTest {
    public static void main(String[] args) {
        Product product = new Product();
        product.setIsflag(false);
        Customer customer = new Customer(product);
        Producer producer = new Producer(product);
        Thread thread1 = new Thread(producer);
        Thread thread2 = new Thread(customer);
        thread1.start();
        thread2.start();
    }
}
