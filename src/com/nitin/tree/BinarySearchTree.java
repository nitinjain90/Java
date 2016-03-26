package com.nitin.tree;

import sun.misc.FloatingDecimal;

/**
 * Created by harsh on 3/23/16.
 *
 *        1
 *           2
 *               3
 *                    4
 *                        5
 *                            6
 *
 *       1) Perfectly balanced tree , height = log(N)
 *       2) Perfectly im-balanced tree, height = N.
 *
 *   1) Changing signature of any function.
 *   2) Adding any new PUBLIC methods.
 *
 *   N numbers
 *   1 add =>
 *
 *
 *   [5,1,2,6,8,4,1,3,6,8]
 *
 *   log(N) => Balanced.
 *
 */
public class BinarySearchTree {

    private BSTNode root;

    public BinarySearchTree() {
       root = null;
    }

    // Best Case :- log(N) , Worst Case :- N.
    public void addNumber(int N) {
       BSTNode sNode = new BSTNode(N);
        if (root == null){
            root = sNode;
            return;
        }

        BSTNode current = root;
        BSTNode xNode = null;

        while(true){
           xNode = current;
            if(N < current.getData()){
                current = current.getLeft();
                if(current == null){
                    xNode.setLeft(sNode);
                    break;
                }
            }else if(N > current.getData()){
                current = current.getRight();
                if(current == null){
                    xNode.setRight(sNode);
                    break;
                }
            }else{
                break;
            }
        }
    }

    //  Destructive balance. O(N).
    public void balance() {

    }


    // First LEFT -> ROOT -> RIGHT
    // O(N) =>
    public void printInOrder() {
        inOrder(root);
        // 1,3,5,10,12
    }

    private static void inOrder(BSTNode node){
        if(node == null){
            return;
        }
        inOrder(node.getLeft());
        System.out.print(node.getData() + " ");
        inOrder(node.getRight());
    }

    // ROOT -> LEFT -> RIGHT
    public void printPreOrder() {
        // 5,3,1,12,10
        preOrder(root);
    }

    public void preOrder(BSTNode node){
        if(node == null){
            return;
        }
        System.out.print(node.getData() + " ");
        preOrder(node.getLeft());
        preOrder(node.getRight());
    }

    // LEFT -> RIGHT -> ROOT
    public void printPostOrder() {
        postOrder(root);
        // 1,3,10,12,5
    }

    public void postOrder(BSTNode node){
        if(node == null){
            return;
        }
        postOrder(node.getLeft());
        postOrder(node.getRight());
        System.out.print(node.getData() + " ");

    }

    private static void myAssert(boolean condition) {
        if (!condition) throw new IllegalStateException("Something is wrong");
    }


    public static void main(String args[]){

        BinarySearchTree xTree = new BinarySearchTree();
        xTree.addNumber(50);
        xTree.addNumber(23);
        xTree.addNumber(56);
        xTree.addNumber(2);

        myAssert(xTree.root.getData() == 50);
        myAssert(xTree.root.getLeft().getData() == 23);
        myAssert(xTree.root.getLeft().getLeft().getData() == 2);
        myAssert(xTree.root.getRight().getData() == 56);

        xTree.printInOrder();
        xTree.printPreOrder();
        xTree.printPostOrder();
    }
}
