package com.chensee.model.Composite_model;

/**
 * 抽象组件（Component）：组合中所有具体组件的抽象接口，用于规范组件的属性和行为，相当于树的节点（Node）。
 */
public abstract class Node {
    // 节点名
    private String name;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    /**
     * 添加节点
     * @param node
     */
    public abstract void add(Node node);

    /**
     * 移除节点
     * @param node
     */
    public abstract void remove(Node node);

    /**
     * 获取子节点
     * @param i
     * @return
     */
    public abstract Node getOne(int i);

    /**
     * 业务方法获得每一个节点
     */
    public abstract void operation();
}
