package com.chensee.model.Adapter_model;

/**
 * 对象适配器模式：需要重新创建一个类引入
 */
public class Adapter2 implements Ps2Inter {

    private USBUser usbUser;

    public Adapter2(USBUser usbUser) {
        this.usbUser = usbUser;
    }

    @Override
    public void isPs2() {
        usbUser.isUSB();
    }
}
