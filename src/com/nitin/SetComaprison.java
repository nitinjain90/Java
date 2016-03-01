package com.nitin;

/**
 * Created by Nitin on 3/1/2016.
 */
public class SetComaprison {
    public static void main(String args[]){
       NitinSet n = new NitinSet();
       SetBinary b = new SetBinary();

        long startTime1 = System.nanoTime();
        for(int i =0; i < 100000; i++){
            n.add("Hello"+i);
        }
        long endTime1 = System.nanoTime();

        System.out.println("To add to normal set :" +(endTime1-startTime1)/1000000+" ms");

        long startTime2 = System.nanoTime();
        for(int i = 0; i < 100000; i++){
            b.add("Hello"+i);
        }
        long endTime2 = System.nanoTime();

        System.out.println("To add to binary set :" +(endTime2-startTime2)/1000000+" ms");
    }
}
/*
 Adding 10 elements


 */