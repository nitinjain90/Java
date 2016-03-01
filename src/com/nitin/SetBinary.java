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



    public static void main(String args[]){
        //adding 1000 elements
        SetBinary n = new SetBinary();

    }

}
//1588ms- 10000 elements