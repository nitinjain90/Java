package com.nitin;

import java.util.ArrayList;

/**
 * Created by harash on 26/02/16.
 */
public class SetBinary {

    private ArrayList<String> data;

    public SetBinary() {
        data = new ArrayList<String>();
    }

    public void add(String s) {
      if(s!=null) {
          if (exists(s)) {
              throw new IllegalArgumentException("Element already exists");
          } else {
              data.add(s);
          }
      }else{
          throw new IllegalArgumentException("null elements not allowed");
      }
    }

    public boolean exists(String s) {
        if (s != null) {
            return new BinarySearch().search(data, s);
        }else{
            throw new IllegalArgumentException("Cant search for null elements");
        }

    }

    public void remove(String s) {
        if (!data.contains(s)) {
            throw new IllegalArgumentException("Element Already exists");
        } else
            data.remove(s);
    }

    public int size(){
        return data.size();
    }

    private static void myAssert(boolean condition) {
        if (!condition) throw new IllegalStateException("Something is wrong");
    }




    public static void main(String args[]){
        SetBinary n = new SetBinary();

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

        n.add(null);
        myAssert(n.size()== 3);
//        n.add("spanish");
        n.add("");
        myAssert(n.exists(""));
        n.add("1234");
        n.add(null);
        n.exists(null);


    }

}
