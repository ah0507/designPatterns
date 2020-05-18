package com.chensee.model.command_model;

/**
 * 具体的命令-移动
*/
public class MoveCommand implements Command {

    /**
     * 命令执行者
     */
    private Receiver receiver;

    public MoveCommand(Receiver receiver) {
        this.receiver = receiver;
    }

    @Override
    public void execute(int status) {
        System.out.println("接受move的命令..");
        receiver.action(status);
    }
}
