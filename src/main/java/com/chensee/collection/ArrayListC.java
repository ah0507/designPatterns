package com.chensee.collection;

import java.util.ArrayList;

/**
 * 特性：允许为空；允许重复数据；有序；线程不安全
 *  基于数组elementData，默认容器为10，1.6版本扩容为n*1.5+1，1.8版本为n*1.5
 *  remove是利用System.arraycopy方法整体复制向前移动一位，最后一个位置的元素指定为null，这样让gc可以去回收它
 *  因为使用了整体复制比较耗费性能
 *
 * 数组是用transient修饰，使数组不被序列化，如果序列化数组容器可能未满没有必要序列化
 * 作用：加快了序列化的速度，减小了序列化之后的文件大小
 */
public class ArrayListC {
    public static void main(String[] args) {
        new ArrayList();
    }
}
