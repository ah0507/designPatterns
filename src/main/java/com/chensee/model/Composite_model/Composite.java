package com.chensee.model.Composite_model;

import java.util.ArrayList;
import java.util.List;

/**
 * 具体组件（Composite）：组合中每个具体的组件，相当于树的枝节点。
 */
public class Composite extends Node {
    //首先来一个存储的集合
    private List<Node> list = new ArrayList();

    public Composite(String name) {
        this.setName(name);
    }

    @Override
    public void add(Node node) {
        list.add(node);
    }

    @Override
    public void remove(Node node) {
        list.remove(node);
    }

    @Override
    public Node getOne(int c) {
        Node c1 =list.get(c);
        return c1;
    }

    @Override
    public void operation(){
        System.out.println(this.getName());
        for(Node node:list){
            // 递归
            node.operation();
        }
    }
}
