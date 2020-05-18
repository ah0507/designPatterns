package com.chensee.model.strategy_model.duck;

public class Quack implements QuackBehavior{
    @Override
    public void quack() {
        System.out.println("会叫");
    }
}
