package com.chensee.model.strategy_model.computer;

public class Envirment {
    private Strategy strategy;

    public Envirment(Strategy strategy) {
        this.strategy = strategy;
    }

    public int call(int a,int b) {
        return strategy.compute(a,b);
    }
}
