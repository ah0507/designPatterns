package com.chensee.util;

import lombok.Data;

/**
 * @author ah
 * @title: Node
 * @date 2020/5/8 12:56
 */
@Data
public class Node {

    private int index;
    private Node next;

    public Node(int i){
        this.index = i;
        this.next = null;
    }
}
