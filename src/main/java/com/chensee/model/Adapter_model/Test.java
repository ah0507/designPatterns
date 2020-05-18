package com.chensee.model.Adapter_model;

public class Test {
    public static void main(String[] args) {
        //类适配器模式
        Ps2Inter ps2Inter = new Adapter1();
        ps2Inter.isPs2();
        //对象适配器模式
        Ps2Inter ps2Inter2 = new Adapter2(new USBUser());
        ps2Inter2.isPs2();

    }
}
