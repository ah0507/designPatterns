package com.chensee.model.builder_model;

/**
 * 建造者模式：隔离了客户与对象的生产过程，二是：负责控制产品对象的生产过程
 */
public class Test {
    public static void main(String[] args) {
        Director director = new Director(new ConcreteBuilder());
        Product construct = director.construct();
        System.out.println(construct);
    }
}
