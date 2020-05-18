package com.chensee.model.builder_model;

public class ConcreteBuilder implements Builder {

    private Product product;

    public ConcreteBuilder() {
        this.product = new Product();
    }

    @Override
    public void buildPartA() {
        System.out.println("开始建造A");
        product.setPartA("AAA");
    }

    @Override
    public void buildPartB() {
        System.out.println("开始建造B");
        product.setPartB("BBB");
    }

    @Override
    public void buildPartC() {
        System.out.println("开始建造C");
        product.setPartC("CCC");
    }

    @Override
    public Product construct() {
        System.out.println("建造完成....");
        return this.product;
    }
}
