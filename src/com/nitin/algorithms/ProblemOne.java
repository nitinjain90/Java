package com.nitin.algorithms;

import java.util.ArrayList;
import java.util.Collections;

/**
 * Created by harash on 03/05/16.
 */
public class ProblemOne {




    public static String combinations(int a){
        String result = ""+a;
        while(a != 1){
            if(a%2 == 0){
                a = a/2;
                result = result + " "+a;
            }else{
                a = 3*a + 1;
                result = result + " "+a;
            }
        }
        return result;
    }



    public static void maxCombinations(int a , int b){
       ArrayList<Integer> counts = new ArrayList<>();
       for(int i = a; i <=b; i++){
           String result = combinations(i);
           String resultarray[] = result.split("\\s+");
           counts.add(resultarray.length);
       }
        Collections.sort(counts);
        System.out.println(a +" "+b+" "+counts.get(counts.size() - 1));
    }

    public static void main(String args[]){
//        if(args.length != 2){
//            throw new IllegalArgumentException("Need exact two arguments");
//        }
        maxCombinations(Integer.parseInt(args[0]) , Integer.parseInt(args[1]));
    }
}
