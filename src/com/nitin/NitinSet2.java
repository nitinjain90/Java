package com.nitin;

import java.util.ArrayList;

/**
 * Created by harash on 26/02/16.
 */
public class NitinSet2 {

    private ArrayList<String> a;
    int length;
    BinarySearch b;

    public NitinSet2() {
        a = new ArrayList<String>();
        length = a.size();
        b = new BinarySearch();
    }

    public void add(String s) {
      if(s!=null) {
          if (b.searchString(a, s) == true) {
              System.out.println("Element already exists");
          } else {
              a.add(s);
          }
      }else
      {
          System.out.println("Null elements not allowed");
      }
    }

    public static void main(String args[]){
        //adding 1000 elements
        NitinSet2 n = new NitinSet2();

//        for(int i = 0; i < 10; i++){
//            n.add("hello"+i);
//        }
//        long endTime = System.nanoTime();
//        n.add("hello4");
//        System.out.println("Time taken = "+(endTime - startTime)/1000000+" ms");
    }

}
//1768ms