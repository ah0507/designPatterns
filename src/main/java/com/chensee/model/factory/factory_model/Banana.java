package com.chensee.model.factory.factory_model;

public class Banana implements Product {
    @Override
    public void produce() {
        System.out.println("生产香蕉...");
    }
}
