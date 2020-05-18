package com.chensee.model.factory.abstractFactory_model;

import com.chensee.model.factory.factoryMethod_model.Clothes;
import com.chensee.model.factory.factoryMethod_model.Shoes;

/**
 * @author gaohang
 *  抽象工厂模式
 */
public abstract class AbstractFactory {
    public abstract Clothes createClothes();
    public abstract Shoes createShoes();
}
