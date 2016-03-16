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
    public int height() {
        if (this.isLeaf()) {
            return 1;
        } else {
            return 1 + Math.max(this.getLeft().height(), this.getRight().height());
        }
    }

    public  int count() {

        TNode left = this.getLeft();
        TNode right = this.getRight();

        int size = 1;

        if (left != null)
            size = size + left.count();

        if (right != null)
            size = size + right.count();

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
        myAssert(t.height() == 2);
        myAssert(t.count() == 3);

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

        myAssert(n.height() == 3);
        myAssert(n.count() == 7);
        
    }
}
