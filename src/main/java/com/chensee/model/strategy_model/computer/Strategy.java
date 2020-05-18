package com.chensee.model.strategy_model.computer;

/**
 * 策略模式属于对象的行为模式。其用意是针对一组算法，将每一个算法封装到具有共同接口的独立的类中，
 * 从而使得它们可以相互替换。策略模式使得算法可以在不影响到客户端的情况下发生变化。
 *
 * 策略模式就是封装不同的算法，通过面向接口式编程完成用户所选择的算法的实现，
 * 用户无需知道如何实现，只需要知道具体执行的行为
 */
public interface Strategy {

    int compute(int a,int b);
}
