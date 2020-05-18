package com.chensee.model.Bridge_model;

/**
 *  桥接模式 将抽象化(Abstraction)与实现化(Implementation)脱耦，使得二者可以独立地变化
 */
public class Test {
    public static void main(String[] args) {
        Shape redCircle = new Circle(100,100, 10, new RedCircle());
        Shape greenCircle = new Circle(100,100, 10, new GreenCircle());
        redCircle.draw();
        greenCircle.draw();
    }
}
