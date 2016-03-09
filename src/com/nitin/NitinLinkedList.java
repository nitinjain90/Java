package com.nitin;

/**
 * Created by harash on 08/03/16.
 */
public class NitinLinkedList {
    Node top;
    Node bottom;
    int size;


    public class Node {
        String data;
        Node prev;
        Node next;
    }

    public NitinLinkedList() {
        top = null;
        bottom = null;
        size = 0;
    }

    public void addFirst(String s) {
        if (size == 0) {
            top = new Node();
            bottom = new Node();
            top.data = s;
            bottom.data = s;
            size++;
        } else {
            Node previousTop = top;
            top = new Node();
            top.data = s;
            top.next = previousTop;
            top.prev = null;
            previousTop.prev = top;
            size++;
        }
    }

    public void addLast(String s) {
        if (size == 0) {
            top = new Node();
            bottom = new Node();
            top.data = s;
            bottom.data = s;
            size++;
        } else {
            Node previousBottom = bottom;
            bottom = new Node();
            bottom.data = s;
            bottom.next = null;
            bottom.prev = previousBottom;
            previousBottom.next = bottom;
            size++;
        }
    }

    public String removeFirst() {
        String t = top.data;
        top = top.next;
        top.prev = null;
        size--;
        return t;
    }

    public String removeLast() {
        String t = bottom.data;
        bottom = bottom.prev;
        bottom.next = null;
        size--;
        return t;
    }

    private static void myAssert(boolean condition) {
        if (!condition) throw new IllegalStateException("Something is wrong");
    }


    public static void main(String args[]) {
        NitinLinkedList n = new NitinLinkedList();

        n.addLast("1");
        n.addLast("2");
        n.addLast("3");
        n.addLast("4");

        n.addFirst("5");
        myAssert(n.removeFirst().equals("5"));
        myAssert(n.removeFirst().equals("1"));
        myAssert(n.removeLast().equals("4"));

    }

}
