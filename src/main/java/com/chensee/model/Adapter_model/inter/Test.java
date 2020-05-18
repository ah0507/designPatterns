package com.chensee.model.Adapter_model.inter;

/**
 * 接口适配器模式:接口方法太多只用其中的a和b方法 使用抽象类来选择需要的方法
 */
public class Test {
    public static void main(String[] args) {
        A a = new AdapterChild();
        a.a();
        a.b();
    }
}
