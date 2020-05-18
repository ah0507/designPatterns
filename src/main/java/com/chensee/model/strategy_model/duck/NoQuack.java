package com.chensee.model.strategy_model.duck;

public class NoQuack implements QuackBehavior{
    @Override
    public void quack() {
        System.out.println("不会叫");
    }
}
