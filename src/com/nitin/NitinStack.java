package com.nitin;

import java.io.StringBufferInputStream;
import java.util.ArrayList;

/**
 * Created by harash on 04/03/16.
 */
public class NitinStack {

    ArrayList<String> data;


    public NitinStack() {

        data = new ArrayList<String>();
    }

    public void push(String s) {
        data.add(s);
    }

    public String pop() {
       if(isEmpty()){
           throw new IllegalArgumentException("empty stack");
       }
        String tmp = data.get(data.size() -1);
        data.remove(data.size() - 1);
        return tmp;
    }

    public boolean isEmpty() {
        if (data.size() == 0)
            return true;
        else
            return false;
    }

    public String peek() {
       if(isEmpty()){
           throw new IllegalArgumentException("empty stack");
       }
        return data.get(data.size() - 1);
    }


    private static void myAssert(boolean condition) {
        if (!condition) throw new IllegalStateException("Something is wrong");
    }


    public static void main(String args[]) {
        NitinStack n = new NitinStack();

        myAssert(n.isEmpty());

        n.push("mumbai");
        n.push("chennai");
        n.push("bangalore");
        n.push("kolkata");
        n.push("delhi");

        myAssert(n.peek() == "delhi");
        myAssert(n.pop() == "delhi");
        myAssert(n.pop() == "kolkata");

        myAssert(n.peek() == "bangalore");


        myAssert(!n.isEmpty());

        myAssert(n.pop() == "bangalore");
        myAssert(n.pop() == "chennai");
        myAssert(n.pop() == "mumbai");

        myAssert(n.isEmpty());

        n.push(null);
        n.push(null);

        myAssert(n.pop() == null);
        myAssert(n.pop() == null);

        n.push("");
        n.push(null);

        myAssert(n.peek() == null);

        n.push("hello");
        myAssert(n.peek() == "hello");

        myAssert(n.pop() == "hello");
        myAssert(n.pop() == null);
        myAssert(n.pop() == "");
        myAssert(n.isEmpty());

        //corner Cases
        n.pop();
        n.peek();



    }
}
