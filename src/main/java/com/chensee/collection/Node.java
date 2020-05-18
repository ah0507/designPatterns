package com.chensee.collection;

import java.util.Map;

/**
 * hashMap中数组加链表结构
 * 数组：Node<K,V>[]
 * next形成树结构
 * 1.7版本会导致next树链表会越来越长影响查询效率
 *
 * 1.8加入红黑树不需要去找链表查询，通过红黑树查询效率提升：
 * 1.TREEIFY_THRESHOLD 用于判断是否需要将链表转换为红黑树的阈值
 * 2.Entry 修改为 Node
 * @param <K>
 * @param <V>
 */
public class Node<K,V> implements Map.Entry<K,V> {

    private K key;

    private V value;

    private Node<K, V> next;

    private int hash;

    public Node(int h,K k,V v,Node<K,V> next){
        this.key = k;
        this.value = v;
        this.hash = h;
        this.next = next;
    }

    @Override
    public K getKey() {
        return key;
    }

    @Override
    public V getValue() {
        return value;
    }

    /**
     * 返回覆盖之前的旧值
     * @param newValue
     * @return oldValue
     */
    @Override
    public V setValue(V newValue) {
        V oldValue = this.value;
        this.value = newValue;
        return oldValue;
    }
}
