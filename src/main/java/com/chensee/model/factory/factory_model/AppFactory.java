package com.chensee.model.factory.factory_model;

public class AppFactory implements Factory {
    @Override
    public Product product() {
        return new Apple();
    }
}
