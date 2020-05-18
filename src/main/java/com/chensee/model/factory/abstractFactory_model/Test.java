package com.chensee.model.factory.abstractFactory_model;

import com.chensee.model.factory.factoryMethod_model.Clothes;
import com.chensee.model.factory.factoryMethod_model.Shoes;

public class Test {

    public static void main(String[] args) {
        AbstractFactory af = new AFactory();
        Clothes clothes = af.createClothes();
        clothes.run();
        Shoes shoes = af.createShoes();
        shoes.run();
        System.out.println("--------------");
        AbstractFactory af1 = new BFactory();
        Clothes clothes1 = af1.createClothes();
        clothes1.run();
        Shoes shoes1 = af1.createShoes();
        shoes1.run();
    }
}
