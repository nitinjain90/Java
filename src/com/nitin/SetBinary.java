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
              System.out.println("Element already exists");
          } else {
              data.add(s);
          }
      }else
      {
          System.out.println("Null elements not allowed");
      }
    }

    public boolean exists(String s){
        return new BinarySearch().search(data , s);
    }

    public void remove(String s) {
        if (!data.contains(s)) {
            System.out.println("Element does not exist");
        } else
            data.remove(s);
    }

    public int length(){
        return data.size();
    }
    private static void myAssert(boolean condition) {
        if (!condition) throw new IllegalStateException("Something is wrong");
        else
            System.out.println("Correct");
    }

    private static boolean myPersonalAssert(boolean condition){
        if(condition == true)
            return true;
        else
            return false;
    }



    public static void main(String args[]){
        //adding 1000 elements
        SetBinary n = new SetBinary();
//        n.add("New york");
//        n.add("california");
//        n.add("mumbai");
//
//        n.add("california");
//
//        n.add("ludhiana");
//        n.add("moscow");
//        n.add("bangkok");
////        myAssert(n.length() == 3);
//
//        System.out.println(myPersonalAssert(n.length() == 6));
//        System.out.println(myPersonalAssert(n.length()==5));
//        myAssert(n.exists("mumbai"));
//        System.out.println(myPersonalAssert(n.exists("mummbai") == false));


    }

}
//1588ms- 10000 elements