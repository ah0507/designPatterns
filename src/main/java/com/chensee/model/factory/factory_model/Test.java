package com.chensee.model.factory.factory_model;

/**
 * 抽象工厂
 */
public class Test {
    public static void main(String[] args) {
        Factory factory = new AppFactory();
        Product product = factory.product();
        product.produce();
    }
}
