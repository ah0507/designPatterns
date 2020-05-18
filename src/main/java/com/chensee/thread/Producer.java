package com.chensee.thread;

public class Producer implements Runnable{

    private Product product;

    public Producer(Product product) {
        this.product = product;
    }

    @Override
    public void run() {
        Integer i=0;
        synchronized (product){
            for (int j=0;j<50;j++){
                if(!product.getIsflag()){
                    if(i%2==0){
                        product.setName("西瓜");
                        product.setPrice(15);
                    }else{
                        product.setName("苹果");
                        product.setPrice(2);
                    }
                    System.out.println("生产者生产了"+ product.getName()+"，价格是："+ product.getPrice()+"元。");
                    i++;
                    product.setIsflag(true);
                    product.notify();
                }else{
                    try {
                        product.wait();
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            }
        }
    }
}
