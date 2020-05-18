package com.chensee.model.strategy_model.duck;

public class NoFly implements FlyBehavior {
    @Override
    public void fly() {
        System.out.println("不会飞");
    }
}
