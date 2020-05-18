package com.chensee.model.Composite_model;

/**
 * 未端具体组件（Leaf）：位于未端面的具体组件，没有子节点，相当于树的叶子节点
 */
public class Leaf extends Node{

    public Leaf(String name) {
        this.setName(name);
    }

    @Override
    public void add(Node node) {
        // 叶子节点不能添加子节点
        throw new RuntimeException("Leaf cannot add element!!");
    }

    @Override
    public void remove(Node node) {
        // 叶子节点没有子节点可以被删除
        throw new RuntimeException("Cannot remove element because Leaf have no Child Node!!");
    }

    @Override
    public Node getOne(int i) {
        return null;
    }

    @Override
    public void operation() {
        System.out.println(this.getName());
    }
}
