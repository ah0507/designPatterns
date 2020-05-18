package com.chensee.model.Observer_model;

/**
 * 观察者模式：观察者接口中有观察方法，被观察者接口中有注册取消观察、通知观察者方法，
 * 具体的被观察者中有某状态和观察者集合的成员变量，初始化传入某状态，
 * 通过方法增减观察者集合的数量，通知观察者方法中循环集合调用每个观察者的方法传入具体的状态来通知观察者
 * 改变某状态时调用通知观察者方法
 * 例如消息订阅与取消，listen监听
 */
public class Test {
    public static void main(String[] args) {
        Cup cup = new Cup(100);
        Observer observer1 = new Person("张三");
        Observer observer2 = new Person("里斯");
        cup.register(observer1);
        cup.register(observer2);
        cup.setPrice(102);

    }
}
