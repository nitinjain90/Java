package com.nitin;

/**
 * Created by harash on 26/02/16.
 */
public class ListPerformance {

    public static void main(String args[]) {
        NitinArrayList n = new NitinArrayList();
        NitinArrayList2 n2 = new NitinArrayList2();
        NitinArrayList3 n3 = new NitinArrayList3();


        //adding 10000 elements
        long nStartTime = System.nanoTime();
        for (int i = 0; i < 100000; i++) {
            n.add("nitin" + i);
        }
        long nEndTime = System.nanoTime();

        System.out.println("To add in list with dynamic Buffer :" +(nEndTime-nStartTime)/1000000+" ms");

        long n1StartTime = System.nanoTime();
        for (int i = 0; i < 100000; i++) {
            n2.add("harsh" + i);
        }
        long n1EndTime = System.nanoTime();

        System.out.println("To add in list with no Buffer :" +(n1EndTime-n1StartTime)/1000000+" ms");

        long n2StartTime = System.nanoTime();
        for (int i = 0; i < 100000; i++) {
            n3.add("hello" + i);
        }
        long n2EndTime = System.nanoTime();

        System.out.println("To add in list with constant Buffer :" +(n2EndTime-n2StartTime)/1000000+" ms");


    }
}
// 10000 elements
//To add in list with dynamic Buffer :50 ms
//To add in list with no Buffer :170 ms
//To add in list with constant Buffer :11 ms

//100000 elements
//To add in list with dynamic Buffer :262 ms
//To add in list with no Buffer :8520 ms
//To add in list with constant Buffer :175 ms
