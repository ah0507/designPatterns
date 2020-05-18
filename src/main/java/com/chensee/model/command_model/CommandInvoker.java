package com.chensee.model.command_model;

/**
 * 创建命令指挥官
 */
public class CommandInvoker {

    private Command command;

    public CommandInvoker(Command command) {
        this.command = command;
    }

    public void action(int status) {
        command.execute(status);
    }
}
