package com.nitin;

/**
 * Created by harash on 10/03/16.
 */
public class LinkedList {
    Node top;
    Node bottom;
    int size;


    public class Node {
        String data;
        Node prev;
        Node next;

        public Node(String data, Node prev, Node next) {
            this.data = data;
            this.prev = prev;
            this.next = next;
        }

        public Node getNext() {
            return next;
        }

        public Node getPrev() {
            return prev;
        }

        public void setNext(Node next) {
            this.next = next;
        }

        public void setPrev(Node prev) {
            this.prev = prev;
        }

        public String getData() {
            return data;
        }

        public void setData(String data) {
            this.data = data;
        }
    }

    public LinkedList() {
        top = null;
        bottom = null;
        size = 0;
    }

    public boolean isEmpty() {
        return (top == null);
    }

    public void addFirst(String s) {
        Node n = new Node(s, null, null);
        if (isEmpty()) {
            top = n;
            bottom = n;
        } else {
            top.setPrev(n);
            n.setNext(top);
            top = n;
            n.setPrev(null);
        }
        size++;
    }

    public void addLast(String s) {
        Node n = new Node(s, null, null);
        if (isEmpty()) {
            top = n;
            bottom = n;
        } else {
            bottom.setNext(n);
            n.setPrev(bottom);
            bottom = n;
            n.setNext(null);
        }
        size++;
    }

    public String removeFirst() {
        if (isEmpty()) {
            throw new IllegalArgumentException("Empty list");
        }

        if (size == 1) {
            String temp = top.getData();
            top = null;
            bottom = null;
            size--;
            return temp;
        }
        String temp = top.getData();
        top = top.next;
        top.setPrev(null);
        size--;
        return temp;
    }

    public String removeLast() {
        if (isEmpty()) {
            throw new IllegalArgumentException("Empty list");
        }

        if (size == 1) {
            String temp = bottom.getData();
            top = null;
            bottom = null;
            size--;
            return temp;
        }
        String temp = bottom.getData();
        bottom = bottom.prev;
        bottom.setNext(null);
        size--;
        return temp;
    }

    private static void myAssert(boolean condition) {
        if (!condition) throw new IllegalStateException("Something is wrong");
    }

    public static void main(String args[]) {
        LinkedList link = new LinkedList();

        link.addLast("1");
        link.addLast("2");
        link.addLast("3");
        link.addLast("4");
        link.addFirst("5");
        link.addFirst("6");
        link.addLast("7");

        myAssert(link.removeFirst().equals("6"));
        myAssert(link.removeFirst().equals("5"));
        myAssert(link.removeFirst().equals("1"));
        myAssert(link.removeFirst().equals("2"));
        myAssert(link.removeFirst().equals("3"));
        myAssert(link.removeFirst().equals("4"));
        myAssert(link.removeFirst().equals("7"));

        myAssert(link.isEmpty());


        link.addFirst("1");
        link.addFirst("2");
        link.addFirst("3");
        link.addFirst("4");
        link.addFirst("5");

        myAssert(link.removeLast().equals("1"));
        myAssert(link.removeLast().equals("2"));
        myAssert(link.removeLast().equals("3"));
        myAssert(link.removeLast().equals("4"));
        myAssert(link.removeLast().equals("5"));

        myAssert(link.isEmpty());

        link.addLast("hello");
        link.addFirst("world");
        myAssert((link.removeFirst() + " " +link.removeLast()).equals("world hello"));

        myAssert(link.isEmpty());

//        link.removeFirst();
//        link.removeLast();

       link.addFirst(null);
        myAssert(link.removeFirst()== null);

        myAssert(link.isEmpty());

        link.addLast(null);
        myAssert(link.removeLast()==null);

    }


}
