package com.chensee.model.Adapter_model;

/**
 * 类适配器模式：可重用的类就用继承
 */
public class Adapter1 extends USBUser implements Ps2Inter {
    @Override
    public void isPs2() {
        super.isUSB();
    }
}
