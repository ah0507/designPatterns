package com.chensee.model.command_model;

/**
 * 命令模式：首先有命令的接口和执行者的接口，子类实现具体的命令和具体的执行者
 *  某命令类中执行者接口作为成员变量引入，命令方法调用执行者接口中执行方法，初始化中传入具体的某执行者
 *  命令者类中引入命令接口作为成员变量，方法中调用命令接口的命令方法，初始化传入具体下达的命令
 *  例如流程中回退和下一步
 */
public class Test {
    public static void main(String[] args) {
        Command command = new MoveCommand(new ReceiverPerson(0));
        CommandInvoker commandInvoker = new CommandInvoker(command);
        commandInvoker.action(1);
    }
}
