package com.chensee.model.strategy_model.duck;

public class Duck2 extends Duck{

    private FlyBehavior flyBehavior;
    private QuackBehavior quackBehavior;

    public Duck2() {
        flyBehavior = new NoFly();
        quackBehavior = new Quack();
    }

    @Override
    public void display() {
        System.out.println("不会飞只会叫的绿鸭子...");
        flyBehavior.fly();
        quackBehavior.quack();
    }



}
