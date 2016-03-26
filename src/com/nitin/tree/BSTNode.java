package com.nitin.tree;

/**
 * Created by harsh on 3/23/16.
 */
public class BSTNode {

    private int data;
    private boolean isBlack;

    private BSTNode left;
    private BSTNode right;

    public BSTNode(int data) {
        this.data = data;
    }

    public void setLeft(BSTNode left) {
        this.left = left;
    }

    public void setRight(BSTNode right) {
        this.right = right;
    }

    public BSTNode getLeft() {
        return left;
    }

    public BSTNode getRight() {
        return right;
    }
    public int getData(){
        return this.data;
    }

    public boolean isBlack() {
        return isBlack;
    }

    public boolean isRed() {
        return !isBlack;
    }

    public void setBlack() {
        isBlack = true;
    }
    public void setRed() {
        isBlack = false;
    }
}
