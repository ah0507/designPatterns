package com.chensee.model.factory.factoryMethod_model;

public class Test {

    public static void main(String[] args) {
        MainFactory mf = new clothesFactory();
        Product p = mf.create();
        p.run();
        System.out.println("--------------");
        MainFactory mf1 = new ShoesFactory();
        Product p1 = mf1.create();
        p1.run();
    }
}
