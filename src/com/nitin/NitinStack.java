package com.nitin;

import java.io.StringBufferInputStream;
import java.util.ArrayList;

/**
 * Created by harash on 04/03/16.
 */
public class NitinStack {

    ArrayList<String> data;
    int length;

    public NitinStack() {
        data = new ArrayList<String>();
        length = 0;
    }

    public void push(String s) {
        ArrayList<String> temp = new ArrayList<String>();
        temp.add(s);
        for(int i = 0; i < data.size(); i++){
            temp.add(data.get(i));
        }
        data = temp;
        length++;
    }

    public String pop() {
        String temp = data.get(0);
        data.remove(0);
        length--;
        return temp;
    }

    public boolean isEmpty() {
        if (data.size() == 0)
            return true;
        else
            return false;
    }

    public String peek() {
        return data.get(0);
    }

    public int search(String s) {
        if (!data.contains(s))
            return -1;
        else
            return data.indexOf(s)+1;
    }

    private static void myAssert(boolean condition) {
        if (!condition) throw new IllegalStateException("Something is wrong");
    }


    public static void main(String args[]){
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

        myAssert(n.search("delhi") == -1);
        myAssert(n.search("kolkata") == -1);
        myAssert(n.peek() == "bangalore");


        myAssert(n.search("chennai") == 2);
        myAssert(n.search("bangalore") == 1);
        myAssert(n.search("mumbai") == 3);
        myAssert(n.search("") == -1);

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
        myAssert(n.search(null) == 1);

        n.push("hello");
        myAssert(n.search("hello") == 1);
        myAssert(n.peek() == "hello");

        myAssert(n.pop() == "hello");
        myAssert(n.search(null) == 1);
        myAssert(n.pop() == null);
        myAssert(n.pop() == "");
        myAssert(n.isEmpty());





    }
}
