package com.chensee.thread.handler;

import lombok.extern.slf4j.Slf4j;


@Slf4j
public class ConsumerHandler extends Thread {

    private ThreadLocal<DoublyLinkedList<MsgAction>> dataList = new ThreadLocal<>();

    public ConsumerHandler (){
        dataList.set(new DoublyLinkedList<MsgAction>());
    }
    @Override
    public void run() {
        while (true) {
            MsgAction action = dataList.get().pop();
            if (action == null) {
                try {
                    sleep(100);
                } catch (InterruptedException e) {
                    log.error("线程wait失败", e);
                }
            }else{
                // TODO
                int opr = action.getOpr();
                switch (opr) {
                    case 1:
                        break;
                    case 2:
                        break;
                    default:
                        break;
                }
            }
        }
    }

    public void addAction(MsgAction action) {
        this.dataList.get().append(action);
    }

}
