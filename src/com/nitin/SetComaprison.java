package com.nitin;

/**
 * Created by Nitin on 3/1/2016.
 */
public class SetComaprison {

    public static void test(int N , int factor , String secondVariable){
        NitinSet n = new NitinSet();
        SetBinary b = new SetBinary();

        long startTime1 = System.nanoTime();
        for(int i =0; i < N; i++){
            n.add("Hello"+i);
        }
        long endTime1 = System.nanoTime();

        System.out.println("To add "+N+" objects to normal set :" +((endTime1-startTime1)/factor)+secondVariable);

        long startTime2 = System.nanoTime();
        for(int i = 0; i < N; i++){
            b.add("Hello"+i);
        }
        long endTime2 = System.nanoTime();

        System.out.println("To add "+N+" objects to binary set :" +((endTime2-startTime2)/factor)+secondVariable);
        System.out.println();
    }

    public static void main(String args[]){
        test(10 , 1 , " nanoseconds");
        test(100 , 1000 , " microseconds");
        test(1000 , 1000000 , " miliseconds");
        test(10000 , 1000000 , " miliseconds");
        test(100000 , 1000000000 , " seconds");
    }
}
/*
 Adding 100 strings
  normal set - 777mcs
  binary set - 10254mcs
 */
/*
  Adding  1000 strings
   normal set - 16ms
   binary set - 37ms
 */
/*
  Adding 10000
   normal set - 549ms
   binary set - 1220ms
 */
/*
 Adding 100000
  normal set - 43s
  binary set - 99s
 */
/*
Adding 1000000
 */