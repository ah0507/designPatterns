package com.chensee.model.strategy_model.duck;

/**
 * 策略模式    java中TreeSet中使用
 * 找出应用中相同之处，且不容易发生变化的东西，把它们抽取到抽象类中，让子类去继承它们；
 * 找出应用中可能需要变化之处，把它们独立出来，不要和那些不需要变化的代码混在一起
 */
public abstract class Duck {

    private FlyBehavior flyBehavior;

    private QuackBehavior quackBehavior;

    public void setFlyBehavior(FlyBehavior flyBehavior) {
        this.flyBehavior = flyBehavior;
    }

    public void setQuackBehavior(QuackBehavior quackBehavior) {
        this.quackBehavior = quackBehavior;
    }

    /**
     * 每个鸭子的颜色不同
     */
    public abstract void display();

    public void swim() {
        System.out.println("公共的都会游泳...");
    }

    public void fly() {
        flyBehavior.fly();
    }

    public void quack() {
        quackBehavior.quack();
    }
}
