package com.chensee.model.factory.factory_model;

public class Apple implements Product {
    @Override
    public void produce() {
        System.out.println("生产苹果...");
    }
}
