package com.chensee.model.Observer_model;

/**
 *  被观察者接口
 */
public interface Observable {

    void register(Observer observer);

    void unreg(Observer observer);

    /**
     * 通知所有观察者
     */
    void informAll();
}
