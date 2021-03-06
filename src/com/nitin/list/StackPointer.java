package com.nitin.list;

/**
 * Created by harash on 08/03/16.
 */

public class StackPointer {

    Node top;


    public class Node {
        String data;
        Node next;
    }


    public StackPointer() {
        top = null;
    }

    public void push(String s) {
        Node previousTop = top;
        top = new Node();
        top.data = s;
        top.next = previousTop;

    }

    public String pop() {
        if (top == null) {
            throw new IllegalArgumentException("empty stack");
        }
        String t = top.data;
        top = top.next;
        return t;
    }

    public String peek() {
        if (top == null) {
            throw new IllegalArgumentException("empty stack");
        }
        return top.data;
    }

    private static void myAssert(boolean condition) {
        if (!condition) throw new IllegalStateException("Something is wrong");
    }

    public int size(){

        int size = 0;
        Node t = top;
        while(t!=null){
            t = t.next;
            size++;
        }

        return size;
    }


    public static void main(String args[]) {
        StackPointer s = new StackPointer();

//        s.pop();

        s.push("hello");
        s.push("world");
        s.push("nitin");
        s.push("kill me");

        myAssert(s.size()== 4);

        myAssert(s.pop().equals("kill me"));
        myAssert(s.size()== 3);
        myAssert(s.pop().equals("nitin"));
        myAssert(s.size()== 2);
        myAssert(s.pop().equals("world"));
        myAssert(s.size()== 1);
        myAssert(s.pop().equals("hello"));
        myAssert(s.size()== 0);

        try {
            s.pop();
        } catch (IllegalArgumentException e) {
            myAssert(true);
        }

        s.push("1");
        s.push("2");
        s.push("3");

        myAssert(s.pop().equals("3"));
        myAssert(s.peek().equals("2"));
        myAssert(s.size()== 2);
        myAssert(s.pop().equals("2"));
        myAssert(s.pop().equals("1"));


        try {
            s.pop();
        } catch (IllegalArgumentException e) {
            myAssert(true);
        }

        s.push(null);
        s.push("");
        s.push("what");

        myAssert(s.size() == 3);

        myAssert(s.pop() == "what");
        myAssert(s.pop() == "");
        myAssert(s.pop() == null);

        s.push("nitin");
        s.push("nitin");

        myAssert(s.pop() == "nitin");
        myAssert(s.pop() == "nitin");

        try {
            s.pop();
        } catch (IllegalArgumentException e) {
            myAssert(true);
        }

    }
}
