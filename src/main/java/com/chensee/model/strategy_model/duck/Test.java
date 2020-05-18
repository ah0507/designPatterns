package com.chensee.model.strategy_model.duck;

public class Test {
    public static void main(String[] args) {
        Duck duck = new Duck1();
        duck.display();
        Duck duckk = new Duck2();
        duckk.display();
        duckk.swim();
    }
}
