package com.chensee.model.Wrapper_model;

/**
 * 装饰者模式
 */
public class Test {
    public static void main(String[] args) {
        Component component = new ConcreteComponent();
        //装饰了A技能
        ConcreteDecoratorA concreteDecoratorA = new ConcreteDecoratorA(component);
        concreteDecoratorA.sampleOpreation();
        //在A的基础上又装饰了B技能
        ConcreteDecoratorB concreteDecoratorB = new ConcreteDecoratorB(concreteDecoratorA);
        concreteDecoratorB.sampleOpreation();
    }
}
