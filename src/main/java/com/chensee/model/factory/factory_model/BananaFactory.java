package com.chensee.model.factory.factory_model;

public class BananaFactory implements Factory {
    @Override
    public Product product() {
        return new Banana();
    }
}
