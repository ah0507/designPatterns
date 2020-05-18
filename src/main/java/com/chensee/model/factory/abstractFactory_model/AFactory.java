package com.chensee.model.factory.abstractFactory_model;

import com.chensee.model.factory.factoryMethod_model.Clothes;
import com.chensee.model.factory.factoryMethod_model.Shoes;

public class AFactory extends AbstractFactory{
    @Override
    public Clothes createClothes() {
        System.out.println("AFactory生产衣服");
        return new Clothes();
    }

    @Override
    public Shoes createShoes() {
        System.out.println("AFactory生产鞋");
        return new Shoes();
    }
}
