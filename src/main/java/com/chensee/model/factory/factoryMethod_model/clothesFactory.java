package com.chensee.model.factory.factoryMethod_model;

public class clothesFactory extends MainFactory {

    @Override
    Product create() {
        return new Clothes();
    }
}
