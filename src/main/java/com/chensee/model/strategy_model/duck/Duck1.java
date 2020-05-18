package com.chensee.model.strategy_model.duck;


public class Duck1 extends Duck{

    private FlyBehavior flyBehavior;
    private QuackBehavior quackBehavior;

    public Duck1() {
        flyBehavior = new Fly();
        quackBehavior = new NoQuack();
//        this.setFlyBehavior(new Fly());
//        this.setQuackBehavior(new NoQuack());
    }

    @Override
    public void display() {
        //TODO
        System.out.println("红鸭子只会飞不会叫...");
        flyBehavior.fly();
        quackBehavior.quack();
    }

}
