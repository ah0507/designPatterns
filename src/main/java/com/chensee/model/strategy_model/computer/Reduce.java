package com.chensee.model.strategy_model.computer;

public class Reduce implements Strategy {
    @Override
    public int compute(int a, int b) {
        return a - b;
    }
}
