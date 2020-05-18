package com.chensee.model.Adapter_model.inter;

public class AdapterChild extends Adapter3{
    @Override
    public void a() {
        super.a();
        System.out.println("a被调用...");
    }

    @Override
    public void b() {
        super.b();
        System.out.println("b被调用...");
    }
}
