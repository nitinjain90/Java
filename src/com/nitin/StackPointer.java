package com.nitin;

import java.util.Stack;

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
        String t = top.data;
        top = top.next;

        return t;
    }

    public String peek() {
        return top.data;
    }



    public static void main(String args[]){
        StackPointer s = new StackPointer();
        s.push("hello");
        s.push("world");
        s.push("nitin");
        s.push("kill me");

        assert s.pop().equals("kill me");
        assert s.pop().equals("nitin");
        assert s.pop().equals("world");
        assert s.pop().equals("hello");


    }
}
