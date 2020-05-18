package com.chensee.model.factory.factoryMethod_model;

public class ShoesFactory extends MainFactory {
    @Override
    Product create() {
        return new Shoes();
    }
}
