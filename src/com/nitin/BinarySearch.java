package com.nitin;

import java.util.*;

/**
 * Created by harash on 09/02/16.
 */
public class BinarySearch {


    public boolean search(ArrayList<String> list , String s){
      int start = 0;
      int end = list.size()-1;

      Collections.sort(list);
        while(start <= end){
            int middle = (start+end)/2;
            if(s.compareTo(list.get(middle)) == 0){
                return true;
            }
            if(s.compareTo(list.get(middle)) > 0){
                start = middle +1;
            }
            if(s.compareTo(list.get(middle)) < 0){
                end = middle - 1;
            }
        }

        return false;
    }

    public boolean search(ArrayList<Integer> list , int i){
        int start = 0;
        int end = list.size()- 1;
        Collections.sort(list);
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
         ArrayList<Integer> a = new ArrayList<>(Arrays.asList(1,2,3,4,5,6,0,-1,-2224444,100000000,111111111, 23432981));
         ArrayList<String> s = new ArrayList<>(Arrays.asList("Nitin","harsh","Hello","world" ,"1234" , "abcdef" , "Nitin"));

         myAssert(b.search(a , 1));
         myAssert(b.search(a, 2));
         myAssert(b.search(a , -2224444));
         myAssert(!b.search(a , 24));
         myAssert(b.search(a, 111111111));

         myAssert(b.search(s , "Nitin"));
         myAssert(b.search(s , "harsh"));
         myAssert(!b.search(s , "honululu"));
         myAssert(b.search(s , "1234"));

      }

}
