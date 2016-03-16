package com.nitin;

/**
 * Created by harsh on 3/15/16.
 */
public class TNode {

    private String data;
    private TNode left;
    private TNode right;

    public TNode(String data) {
        this.data = data;
    }

    public void setLeft(TNode t) {
        this.left = t;
    }

    public void setRight(TNode t) {
        this.right = t;
    }

    public TNode getLeft() {
        return left;
    }

    public TNode getRight() {

        return right;
    }

    public boolean isLeaf() {
        if (this.getLeft() == null && this.getRight() == null)
            return true;
        else
            return false;
    }

    // Do using recursion.
    public static int height(TNode node) {
        if (node == null) {
            return 0;
        } else {
            return 1 + Math.max(height(node.getLeft()), height(node.getRight()));
        }
    }

    public static int count(TNode node) {

        TNode left = node.getLeft();
        TNode right = node.getRight();

        int size = 1;

        if (left != null)
            size = size + left.count(left);

        if (right != null)
            size = size + right.count(left);

        return size;
    }

    private static void myAssert(boolean condition) {
        if (!condition) throw new IllegalStateException("Something is wrong");
    }

    public static void main(String args[]) {
        TNode t = new TNode("hello");
        t.setLeft(new TNode("nitin"));
        t.setRight(new TNode("jain"));
//        myAssert(t.count() == 1);
        myAssert(height(t) == 2);
        myAssert(count(t) == 3);

        myAssert(!t.isLeaf());
        myAssert(t.getLeft().isLeaf());
        myAssert(t.getRight().isLeaf());

        TNode n = new TNode("1");
        TNode l = new TNode("2");
        TNode r = new TNode("3");

        n.setLeft(l);
        n.setRight(r);

        l.setRight(new TNode("4"));
        l.setLeft(new TNode("5"));
        r.setLeft(new TNode("6"));
        r.setRight(new TNode("7"));

        myAssert(height(n) == 3);
        myAssert(count(n) == 7);
        
    }
}
