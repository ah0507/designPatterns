package com.chensee.util;

import java.util.*;

/**
 * @author ah
 * @title: Test
 * @date 2020/5/7 23:16
 */
public class Test {
    public static void main(String[] args) {
        Stack stack = new Stack<String>();
        String[] ints = {"1","dsa","fsdf","2222","141414","424242"};

        for (int i = 0; i < ints.length / 2; i++) {
            String temp = ints[i];
            String temp2 = ints[ints.length - i-1];
            ints[ints.length - i-1] = temp;
            ints[i] = temp2;
        }
        for (int i = 0; i < ints.length; i++) {
            stack.push(ints[i]);
        }
        for (int i = 0; i < 6; i++) {
            ints[i] = (String) stack.pop();
        }
        Queue queue = new ArrayDeque();
        queue.add(111);
        System.out.println(queue.poll());

        Stack stack2 = new Stack<Node>();
        Node node = new Node(1);
        Node node2 = new Node(2);
        Node node3 = new Node(3);

        List<Node> l = new ArrayList<>();
        l.add(node);
        l.add(node2);
        l.add(node3);

        node.setNext(node2);
        node2.setNext(node3);
        while (node != null) {
            stack2.push(node);
            node = node.getNext();
        }
        get(stack2,node,null);
    }

    private static Node get(Stack stack, Node node, Node temp) {
        if (stack.isEmpty()) {
            return node;
        }
        Node pop = (Node) stack.pop();
        pop.setNext(null);
        if (node == null) {
            node = pop;
            return get(stack, node, null);
        } else {
            node.setNext(temp);
            return get(stack, node,temp);
        }
    }
}
