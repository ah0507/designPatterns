package com.chensee.model.Facade_model;

public class Disk implements Common{
    @Override
    public void start() {
        System.out.println("Disk开启");
    }

    @Override
    public void close() {
        System.out.println("Disk关闭");
    }
}
