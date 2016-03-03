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
      }else{
          throw new IllegalArgumentException("null elements not allowed");
      }

    }


    public void remove(String s) {
        if (!data.contains(s)) {
          throw new IllegalArgumentException("Element does not exists");
        } else
            data.remove(s);
    }

    public boolean exists(String s) {
        return data.contains(s);
    }

    public int size() {
        return data.size();
    }



    private static void myAssert(boolean condition) {
        if (!condition) throw new IllegalStateException("Something is wrong");
    }

    public static void main(String args[]) {
        NitinSet n = new NitinSet();

        n.add("hindi");
        n.add("english");
        n.add("bengali");
        n.add("spanish");
        n.add("french");
        n.add("urdu");


        myAssert(n.size() == 6);

        myAssert(n.exists("hindi"));
        myAssert(n.exists("english"));
        myAssert(n.exists("french"));
        myAssert(!n.exists("malyalam"));
        myAssert(!n.exists("French"));

        n.remove("english");
        myAssert(!n.exists("english"));
        myAssert(n.size() == 5);
        n.remove("bengali");
        myAssert(!n.exists("bengali"));
        myAssert(n.size() == 4);
        n.remove("urdu");
        myAssert(!n.exists("urdu"));
        myAssert(n.size() == 3);


        myAssert(n.size()== 3);

        n.add("");
        myAssert(n.exists(""));
        n.add("1234");

        n.remove("");
        n.remove("1234");
        n.remove("spanish");
        n.remove("french");
        n.remove("hindi");

        myAssert(n.size() == 0);


        n.add("park");
        n.add("building");
        n.add("railway station");
        n.add("airport");
        n.add("bus stand");

        myAssert(n.size() == 5);
        myAssert(n.exists("park"));
        myAssert(!n.exists("1234"));




    }
}
//458ms