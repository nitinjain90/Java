package com.nitin;

import java.util.ArrayList;

/**
 * Created by harsh on 1/25/16.
 * <p/>
 * V1 : Do naive implementation.
 * V2 : Using binary search
 * <p/>
 * Performance Analysis.
 */
public class NitinSet {

    private ArrayList<String> data;

    public NitinSet() {
        data = new ArrayList<String>();
    }

    public void add(String s) {
      if(s !=null) {
          if (data.contains(s)) {
              throw new IllegalStateException("Element already exists");
          } else
              data.add(s);
      }

    }


    public void remove(String s) {
        if (!data.contains(s)) {
            System.out.println("Element does not exist");
        } else
            data.remove(s);
    }

    public boolean exists(String s) {
        return data.contains(s);
    }

    public int length() {
        return data.size();
    }

    public void display() {
        for (int i = 0; i < data.size(); i++) {
            System.out.println(data.get(i));
        }
    }

    private static void myAssert(boolean condition) {
        if (!condition) throw new IllegalStateException("Something is wrong");
        else
            System.out.println("Correct");
    }


    public static void main(String args[]) {
        NitinSet n = new NitinSet();
//        n.add("nitin");
//        myAssert(n.exists("nitin"));
//
//        n.remove("nitin");
//        myAssert(n.exists("nitin"));
        n.add("hindi");
        n.add("english");
        n.add("bengali");
        n.add("spanish");
        n.add("french");
        n.add("urdu");

        n.remove("english");

        //n.add("hindi");


        myAssert(n.length() == 5);
        myAssert(n.exists("bengali"));

        n.add(null);
        myAssert(n.length() == 5);

        n.remove("urdu");
        myAssert(n.length() == 4);

        n.remove("german");




    }
}
//458ms