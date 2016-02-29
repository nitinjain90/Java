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
        long startTime = System.nanoTime();
       for(int i = 0; i < 1000000; i++){
            n.add("hello"+i);
        }
        long endTime = System.nanoTime();
//        long startTime = System.nanoTime();
//        for(int i = 0; i < 100000; i++){
//            n.add("hello"+i);
//        }
//        long endTime = System.nanoTime();
//        long startTime = System.nanoTime();
//        for(int i = 0; i < 10000; i++){
//            n.add("hello"+i);
//        }
//        long endTime = System.nanoTime();



        System.out.println("Time taken = "+(endTime - startTime)/1000000000+"s");
    }

}
//1588ms- 10000 elements