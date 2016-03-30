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

    public static void rotateRight(BSTNode n) {
        if (n.isLeaf() || n.getLeft().isLeaf()) {
            throw new IllegalArgumentException("rotation not possible");
        }
        BSTNode child = n.getLeft();
        n.setLeft(child.getRight());
        child.getRight().setParent(n);
        child.setRight(n);
        n.setParent(child);
    }

    public static void rotateLeft(BSTNode n) {
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
    public void insert_case1(BSTNode n) {
        if (n.getParent() == null) {
            n.setBlack();
        } else {
           insert_case2(n);
        }

    }
    // if node parent is black. Everything is good
    public void insert_case2(BSTNode n) {
       if(n.getParent().isBlack()){
           return;
       }else{
         insert_case3(n);
       }
    }
    //
    public void insert_case3(BSTNode n){
         BSTNode u = getUncle(n);
         BSTNode g;
        if(u!=null && u.isRed()){
            n.getParent().setBlack();
            u.setBlack();
            g = getGrandParent(n);
            g.setRed();
            insert_case1(g);
        }else {
           insert_case4(n);
        }
    }
    public void insert_case4(BSTNode n){
        BSTNode g = getGrandParent(n);

        if(n == n.getParent().getRight() && n.getParent() == g.getLeft()){
            rotateLeft(n.getParent());
            n = n.getLeft();
        }else if(n == n.getParent().getLeft() && n.getParent() == g.getRight()){
            rotateRight(n.getParent());
            n = n.getRight();
        }
        insert_case5(n);

    }
    public void insert_case5(BSTNode n){

    }

}
