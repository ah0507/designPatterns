package com.chensee.model.Observer_model;


import java.util.Vector;

public class Cup implements Observable {

    /**
     * 观察者列表容器
     */
    private Vector<Observer> observers = new Vector<Observer>();

    private float price;

    public Cup(float price) {
        this.price = price;
    }

    public float getPrice() {
        return price;
    }

    public void setPrice(float price) {
        this.price = price;
        this.informAll();
    }

    @Override
    public void register(Observer observer) {
        observers.add(observer);
    }

    @Override
    public void unreg(Observer observer) {
        observers.remove(observer);
    }

    @Override
    public void informAll() {
        for (Observer observer : observers) {
            observer.update(price);
        }
    }
}
