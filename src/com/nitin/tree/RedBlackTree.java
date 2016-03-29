package com.nitin.tree;

/**
 * Created by harsh on 3/26/16.
 */
public class RedBlackTree {

    BSTNode root;

    public RedBlackTree() {
        this.root = null;
        root.isBlack();
    }

    public void addNumber(int N) {

    }

    private BSTNode getGrandParent(BSTNode n) {
        if (n != null && n.getParent() != null) {
            return n.getParent().getParent();
        } else {
            return null;
        }
    }

    private BSTNode getUncle(BSTNode n) {
        BSTNode gp = getGrandParent(n);
        if (gp == null) {
            return null;
        }
        if (n.getLeft() == gp.getLeft()) {
            return gp.getRight();
        } else {
            return gp.getLeft();
        }
        

    }

}
