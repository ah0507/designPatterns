package com.chensee.model.Wrapper_model;

/**
 * 具体装饰(ConcreteDecorator)角色：负责给构件对象“贴上”附加的责任
 */
public class ConcreteDecoratorA extends Decorator {
    public ConcreteDecoratorA(Component component) {
        super(component);
    }

    @Override
    public void sampleOpreation() {
        super.sampleOpreation();
        //TODO 完成相关的业务代码
    }
}
