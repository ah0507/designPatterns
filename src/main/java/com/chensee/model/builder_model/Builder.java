package com.chensee.model.builder_model;

public interface Builder {
    void buildPartA();

    void buildPartB();

    void buildPartC();

    Product construct();
}
