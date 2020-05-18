package com.chensee.model.Facade_model;

/**
 * 外观模式（门面模式）
 * 1）.门面角色：外观模式的核心。它被客户角色调用，它熟悉子系统的功能。内部根据客户角色的需求预定了几种功能的组合。
 * 2）.子系统角色:实现了子系统的功能。它对客户角色和Facade时未知的。它内部可以有系统内的相互交互，也可以由供外界调用的接口。
 * 3）.客户角色:通过调用Facede来完成要实现的功能。
 * 优点
 * 使客户端和子系统之间解耦，子系统更易扩展和维护，隐藏了子系统的细节
 */
public class Test {
    public static void main(String[] args) {
        Computer computer = new Computer();
        computer.start();
        computer.close();
    }
}
