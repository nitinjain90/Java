package com.nitin;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;

/**
 * Created by harash on 09/02/16.
 */
public class BinarySearch {

    public boolean search(ArrayList<Integer> list , int i){
        int start = 0;
        int end = list.size()- 1;
        while(start <= end){
            int middle = (start+end)/2;
            if(i == list.get(middle)){
                return true;
            }
            if(i > list.get(middle)){
                start = middle +1;
            }
            if(i < list.get(middle)){
                end = middle - 1;
            }
        }

        return false;
    }

    private static void myAssert(boolean condition) {
        if (!condition) throw new IllegalStateException("Something is wrong");
    }

     public static void main (String args[]){
         BinarySearch b = new BinarySearch();
         ArrayList<Integer> a = new ArrayList<>(Arrays.asList(1,2,3,4,5,6));
         Collections.sort(a);

         myAssert(b.search(a, 2));
         myAssert(b.search(a, 6));

        ArrayList<Integer> a2 = new ArrayList<>();
         myAssert(!b.search(a2, 1));
      }

}
