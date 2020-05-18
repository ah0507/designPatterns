package com.chensee.model.command_model;

public class ReceiverPerson implements Receiver {

    private int status;

    public ReceiverPerson(int status) {
        this.status = status;
    }

    @Override
    public void action(int status) {
        this.status = status;
        System.out.println("员工接收命令并且执行命令..."+status);
    }
}
