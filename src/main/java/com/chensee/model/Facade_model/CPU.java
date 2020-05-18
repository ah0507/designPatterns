package com.chensee.model.Facade_model;

public class CPU implements Common{
    @Override
    public void start() {
        System.out.println("cpu开启");
    }

    @Override
    public void close() {
        System.out.println("cpu关闭");
    }
}
