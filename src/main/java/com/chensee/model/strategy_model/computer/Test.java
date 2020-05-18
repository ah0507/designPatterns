package com.chensee.model.strategy_model.computer;


public class Test {
    public static void main(String[] args) {
        Envirment envirment = new Envirment(new Add());
        int count = envirment.call(1, 2);
        System.out.println("count = " + count);
    }
}
