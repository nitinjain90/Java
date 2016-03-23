package com.nitin.list;

import com.nitin.list.ArrayListConstant;
import com.nitin.list.ArrayListDynamic;
import com.nitin.list.ArrayListNoBuffer;

/**
 * Created by harash on 26/02/16.
 */
public class ListPerformance {

    public static void test(int N, int factor, String secondVariable) {
        ArrayListDynamic n = new ArrayListDynamic();
        ArrayListNoBuffer n2 = new ArrayListNoBuffer();
        ArrayListConstant n3 = new ArrayListConstant();


        //adding 10000 elements
        long nStartTime = System.nanoTime();
        for (int i = 0; i < N; i++) {
            n.add("nitin" + i);
        }
        long nEndTime = System.nanoTime();

        System.out.println("To add "+N+ " objects in list with dynamic Buffer :" + ((nEndTime - nStartTime) / factor) + secondVariable);

        long n1StartTime = System.nanoTime();
        for (int i = 0; i < N; i++) {
            n2.add("harsh" + i);
        }
        long n1EndTime = System.nanoTime();

        System.out.println("To add "+N+" objects in list with no Buffer :" + ((n1EndTime - n1StartTime) / factor) + secondVariable);

        long n2StartTime = System.nanoTime();
        for (int i = 0; i < N; i++) {
            n3.add("hello" + i);
        }
        long n2EndTime = System.nanoTime();

        System.out.println("To add "+N+" objects in list with constant Buffer :" + ((n2EndTime - n2StartTime) / factor) + secondVariable);
        System.out.println();
    }

    public static void main(String args[]) {
        test(10, 1, " nanoseconds");
        test(100, 1000, " microseconds");
        test(1000, 1000, " microseconds");
        test(10000, 1000000, " miliseconds");
        test(100000, 1000000, " miliseconds");
    }
}
/*
adding 10 elemments
    dymanic - 332 microseconds
    no Buffer - 137 microseconds
    constant Buffer - 151 microsecons
 */
/*
adding 100 elements
    dymanic - 894 mcs
    no Buffer - 1626 mcs
    constant Buffer - 761 mcs
 */
/*
adding 1000 elements
    dymanic -  7442 mcs
    no Buffer - 34690 mcs
    constant Buffer - 10488 mcs
 */
/*
adding 100000
   dynamic - 135 ms
   no Buffer - 27689 ms
   constant Buffer - 552 ms
 */

/*
Coclusion - As the number of element to add starts increasing dumanic buffer is most efficient.
            For a very small size 0-20 - no buffer
            for low to medium - constant buffer as it saves memoey and more or less efficiency is same as dynamic
            For huge numbers - dynamic is more than 100x faster and efficiency increases exponentially with regards to no buffer
                               and linearly with regards to constant buffer

 */



