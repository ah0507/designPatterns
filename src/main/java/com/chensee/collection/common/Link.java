package com.chensee.collection.common;

import java.util.HashSet;
import java.util.Set;

/**
 * @author ah
 * @title: Link 判断链表是否有环
 * @date 2020/5/7 17:18
 */
public class Link {
    class Node {
        int val;
        Node next;

        Node(int val) {
            val = val;
            next = null;
        }
    }

    /**
     * 判断链表是否有环
     * 声明两个指针，一个一次经过两个节点，另一个一次经过一个节点，如果有环两个一定会相遇
     * @param head
     * @return
     */
    public boolean isHaveCycle(Node head) {
        Node quick = head;
        Node slow = head;
        while (quick != null && slow != null) {
            quick = quick.next.next;
            slow = quick.next;
            if (quick == slow) {
                return true;
            }
        }
        return false;
    }

    /**
     * 遍历节点，遍历一个标记一个，遍历中判断是否被标记，如果已标记则说明有环
     * @param head
     * @return
     */
    public boolean isHaveCycle2(Node head) {
        Set<Node> nodes = new HashSet<>();
        while (head != null) {
            if (nodes.contains(head)) {
                return true;
            }else{
                nodes.add(head);
                head = head.next;
            }
        }
        return false;
    }
}
