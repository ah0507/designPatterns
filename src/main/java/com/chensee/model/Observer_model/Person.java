package com.chensee.model.Observer_model;

public class Person implements Observer {

    private String name;

    public Person(String name) {
        this.name = name;
    }

    @Override
    public void update(float price) {
        System.out.println(this.name+"关注的cup的价格变为"+price+"元");
    }
}
