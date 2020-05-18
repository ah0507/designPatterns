package com.chensee.thread.handler;

public class HandlerManager {

    private ConsumerHandler[] consumerHandlers;

    public HandlerManager(int threadCount) {
        this.consumerHandlers = new ConsumerHandler[threadCount];

        for (int i = 0; i < threadCount; i++) {
            this.consumerHandlers[i].start();
        }
    }

    public void addAction(MsgAction action) {
        if (action == null || action.getUserKey() == null) {
            return;
        }
        int i = action.getUserKey().hashCode() % consumerHandlers.length;
        consumerHandlers[i].addAction(action);
    }
}