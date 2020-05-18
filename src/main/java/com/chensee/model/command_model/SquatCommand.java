package com.chensee.model.command_model;

/**
 * 具体的命令-蹲下
 */
public class SquatCommand implements Command {

    /**
     * 命令执行者
     */
    private Receiver receiver;

    public SquatCommand(Receiver receiver) {
        this.receiver = receiver;
    }

    @Override
    public void execute(int status) {
        System.out.println("接受Squat的命令.......");
        receiver.action(status);
    }
}
