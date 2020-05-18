package com.chensee.thread.handler;

import lombok.AccessLevel;
import lombok.Getter;
import lombok.Setter;

public class DoublyLinkedList<T> {

    @Getter
    @Setter(AccessLevel.PROTECTED)
    private DllNode head;
    @Getter
    @Setter(AccessLevel.PROTECTED)
    private DllNode tail;

    public synchronized void append(T data) {
        DllNode<T> newNode = new DllNode(data);
        if (this.tail != null) {
            newNode.setPre(this.getTail());
        } else {
            this.head = newNode;
            this.tail = newNode;
        }
    }

    public T pop() {
        if (this.head != null) {
            DllNode<T> oldHead = this.head;
            this.head = this.head.next;
            return oldHead.getData();
        } else {
            return null;
        }
    }

    private class DllNode<T> {
        @Getter
        @Setter
        private DllNode pre;
        @Getter
        @Setter
        private DllNode next;
        @Getter
        private T data;

        public DllNode(T data) {
            this.data = data;
        }
    }

}
