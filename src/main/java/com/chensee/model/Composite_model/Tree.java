package com.chensee.model.Composite_model;

public class Tree {
    private Node root;

    public Node getRoot() {
        return root;
    }

    public void setRoot(Node root) {
        this.root = root;
    }

    public void show() {
        root.operation();
    }
}
