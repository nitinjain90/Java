package com.nitin;

/**
 * Created by harash on 08/03/16.
 */
public class QueuePointer {

    Node bottom;
    Node top;
    int size;

    public class Node {
        String data;
        Node next;
    }

    public QueuePointer() {
        bottom = null;
        top = null;
        size = 0;
    }

    public boolean isEmpty() {
        return (top == null);
    }

    public void push(String s) {
        Node n = new Node();
        n.data = s;
        if (isEmpty()) {
            top = n;
        } else {
            bottom.next = n;
        }
        bottom =n;
        bottom.next = null;
        size++;
    }

    public String pop() {
        if (size <= 0) {
            throw new IllegalArgumentException("empty queue");
        }
        String t = top.data;
        top = top.next;
        size--;
        return t;
    }

    private static void myAssert(boolean condition) {
        if (!condition) throw new IllegalStateException("Something is wrong");
    }

    public static void main(String args[]) {
        QueuePointer q = new QueuePointer();
        q.push("hello");
        q.push("world");
        q.push("nitin");
        q.push("kill me");

        myAssert(q.pop().equals("hello"));
        myAssert(q.pop().equals("world"));
        myAssert(q.pop().equals("nitin"));
        myAssert(q.pop().equals("kill me"));

        q.push("1");
        q.push("2");
        q.push("3");
        q.push("4");
        q.push("5");

        myAssert(q.pop().equals("1"));
        myAssert(q.pop().equals("2"));
        myAssert(q.pop().equals("3"));
        myAssert(q.pop().equals("4"));
        myAssert(q.pop().equals("5"));

        myAssert(!q.pop().equals(""));
    }

}
