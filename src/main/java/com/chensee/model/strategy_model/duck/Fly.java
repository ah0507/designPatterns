package com.chensee.model.strategy_model.duck;

public class Fly implements FlyBehavior {
    @Override
    public void fly() {
        System.out.println("可以飞");
    }
}
