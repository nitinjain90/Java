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
        Node next;

    }

    public NitinLinkedList() {
        top = null;
        bottom = null;
        size = 0;
    }

    public void addFirst(String s) {
        Node n = new Node();
        n.data = s;
        Node previousTop = top;
        if (isEmpty()) {
            top = n;
            bottom = n;
        } else {
            top = n;
        }
        top.next = previousTop;
        size++;
    }

    public boolean isEmpty() {
        return (top == null);
    }

    public void addLast(String s) {
        Node n = new Node();
        n.data = s;
        if (isEmpty()) {
            top = n;
            bottom = n;
            size++;
        } else {
            bottom.next = n;
        }
        bottom = n;
        bottom.next = null;
        size++;
    }

    public String removeFirst() {
        if (isEmpty()) {
            throw new IllegalArgumentException("Empty List");
        }
        Node temp = top;
        top = top.next;
        size--;
        return temp.data;
    }

    public void display() {
        Node t = top;
        while (t != null) {
            System.out.println(t.data);
            t = t.next;
        }
    }


    public String removeLast() {
        if (isEmpty()) {
            throw new IllegalArgumentException("Empty list");
        }
        Node temp = bottom;

        return temp.data;
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
        n.addFirst("6");

        myAssert(n.removeFirst().equals("6"));
        myAssert(n.removeFirst().equals("5"));
        myAssert(n.removeFirst().equals("1"));
        myAssert(n.removeFirst().equals("2"));
        myAssert(n.removeFirst().equals("3"));
        myAssert(n.removeFirst().equals("4"));




        myAssert(n.isEmpty());





    }

}
