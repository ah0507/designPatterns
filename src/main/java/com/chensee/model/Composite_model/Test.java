package com.chensee.model.Composite_model;

/**
 * 组合模式（又称部分-整体模式）
 */
public class Test {
    public static void main(String[] args) {
        // 声明若干节点
        Node root = new Composite("ROOT");
        Node left = new Composite("LEFT");
        Node LEFT1 = new Leaf("LEFT1");
        Node right = new Composite("RIGHT");
        Node RIGHT1 = new Leaf("RIGHT1");
        Node RIGHT2 = new Leaf("RIGHT2");

        // 构造一棵树，遍历看看效果
        left.add(LEFT1);
        right.add(RIGHT1);
        right.add(RIGHT2);
        root.add(left);
        root.add(right);

        Tree tree = new Tree();
        tree.setRoot(root);
        tree.show();
        System.out.println("==========");
        // 删除有节点及其两个叶子子节点
        root.remove(left);
        tree.show();
    }
}
