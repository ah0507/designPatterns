package com.chensee.collection;

import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

/**
 * 基于数组和单向链表,默认容器为16，负载因子为0.75，以key，value形式存储，都可为null，value可重复，key是唯一，无序，线程不安全；
 * 一个键值对是一个存储单元：包括：key，value，hash值和Entry后驱next。
 * hash值是通过调用key的hashcode，并且对这个值进行hash计算，确保唯一。
 * Entry的next存放的是每一个new出Entry存储单元的地址值
 * 地址值（最新一次的地址值）-->key，value，next（上一次的地址值，当put第一个元素时为null），hash
 *
 * 为什么负载因子为0.75？
 *  因为如果是0.5每次达到容量的一般就扩容，可用空间太大，利用率低
 *  如果是1每次空间使用完毕才扩容，在一定程度上会增加put时候的时间。
 */
public class HashMapC {
    Map map = new HashMap();
    //1.7JDK 分段锁ReentrantLock
    //1.8 CAS + synchronized 来保证并发安全性。
    Map map1 = new ConcurrentHashMap();
}

