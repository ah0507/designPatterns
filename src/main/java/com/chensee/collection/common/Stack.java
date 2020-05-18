package com.chensee.collection.common;

/**
 * @author ah
 * @title: Stack栈的结构：先进后出
 * @date 2020/5/6 14:44
 */
public class Stack {
    private String[] items;
    private int size;
    private int index;

    public Stack(int size) {
        this.items = new String[size];
        this.index = 0;
        this.size = size;
    }

    //进栈
    public boolean push(String item) {
        if (index == size) {
            return false;
        }
        items[index] = item;
        index++;
        return true;
    }

    //出栈
    public String pull(){
        if (index == 0) {
            return null;
        }
        String item = items[index - 1];
        index--;
        return item;
    }

    public static void main(String[] args) {
        Stack stack = new Stack(5);
        stack.push("bbb");
        stack.push("ddd");
        stack.push("aaa");
        stack.push("cccc");
        System.out.println(stack.pull());
        System.out.println(stack.pull());
        System.out.println(stack.pull());
        System.out.println(stack.pull());
        System.out.println(stack.pull());
    }
}
