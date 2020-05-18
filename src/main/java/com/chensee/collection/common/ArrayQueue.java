package com.chensee.collection.common;

/**
 * @author ah
 * @title: ArrayQueue 有序数组队列
 * @date 2020/5/5 21:26
 */
public class ArrayQueue {

    private int maxSize;//队列容量

    private int front;//队列头

    private int rear;//队列尾

    private int[] arr;//模拟队列的数组

    public ArrayQueue(int size) {
        maxSize = size;
        arr = new int[maxSize];
        front = -1;
        rear = -1;
    }

    //判断队列是否满
    public boolean isFull() {
        return rear == maxSize - 1;
    }

    //判断队列是否空
    public boolean isEmpty() {
        return rear == front;
    }

    //加入队列
    public void addQueue(int n) {
        if (!isFull()) {
            rear++;
            arr[rear] = n;
        }else{
            throw new RuntimeException("队列已满！");
        }
    }

    //取队列
    public int getQueue() {
        if (!isEmpty()) {
            front++;
            return arr[front];
        } else {
            throw new RuntimeException("---队列为空---");
        }
    }

    public static void main(String[] args) {
        ArrayQueue arrayQueue = new ArrayQueue(5);
        arrayQueue.addQueue(1);
        arrayQueue.addQueue(2);
        System.out.println(arrayQueue.getQueue());
        System.out.println(arrayQueue.getQueue());
        System.out.println(arrayQueue.getQueue());

    }
}