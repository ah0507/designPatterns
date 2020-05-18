package com.chensee.thread;

public class Customer implements Runnable{

    private Product product;

    public Customer(Product product) {
        this.product = product;
    }

    @Override
    public void run() {
        synchronized (product){
            for (int j=0;j<50;j++){
                try {
                    Thread.sleep(500);
                    if(product.getIsflag()){
                        System.out.println("消费者买了"+ product.getName()+"，价格是："+ product.getPrice()+"元。");
                        product.setIsflag(false);
                        product.notify();
                    }else{
                        try {
                            product.wait();
                        } catch (InterruptedException e) {
                            e.printStackTrace();
                        }
                    }
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }
    }
}
