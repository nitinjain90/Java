package com.nitin.tree;

/**
 * Created by harsh on 3/26/16.
 */
public class RedBlackTree {

    BSTNode root;

    public RedBlackTree() {
        this.root = null;

    }


    public void addNumber(int N) {
        BSTNode n = new BSTNode(N);
    }

    private static BSTNode getGrandParent(BSTNode n) {
        if (n != null && n.getParent() != null) {
            return n.getParent().getParent();
        } else {
            return null;
        }
    }

    private static BSTNode getUncle(BSTNode n) {
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

    private static void rotateRight(BSTNode n) {
        if (n.isLeaf() || n.getLeft().isLeaf()) {
            throw new IllegalArgumentException("rotation not possible");
        }
        BSTNode child = n.getLeft();
        n.setLeft(child.getRight());
        child.getRight().setParent(n);
        child.setRight(n);
        n.setParent(child);
    }

    private static void rotateLeft(BSTNode n) {
        if (n.isLeaf() || n.getRight().isLeaf()) {
            throw new IllegalArgumentException("rotation not possible");
        }
        BSTNode child = n.getRight();
        n.setRight(child.getLeft());
        child.getLeft().setParent(n);
        child.setLeft(n);
        n.setParent(child);
    }

    // when node is at the root of the tree

    private static void myAssert(boolean condition) {
        if (!condition) throw new IllegalStateException("Something is wrong");
    }

    public static void main(String args[]){
        RedBlackTree test = new RedBlackTree();
        test.addNumber(43);
        test.addNumber(56);
        test.addNumber(27);

      myAssert(test.root.isBlack());
    }
}
