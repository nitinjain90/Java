package com.nitin.algorithms;

import java.util.ArrayList;

/**
 * Created by harsh on 3/26/16.
 */
public class SequenceAlgorithms {

    int data[];

    public SequenceAlgorithms(ArrayList<Integer> d) {

    }

    public SequenceAlgorithms(int[] d) {
        this.data = d;
    }

    //
    //    10 , 2 , 3 , 5 , 1 , 4 , 6 , 7
    public int longestIncreasingContinuous() {
        int count[] = new int[data.length];
        for(int i = 0; i < count.length; i++){
            count[i] = 1;
        }
        for (int i = 0; i < data.length; i++) {
            int j = i + 1;
            while (j < data.length && data[j-1] <= data[j]) {
                count[i] = count[i] + 1;
                j++;
            }
        }
        int maxValue = count[0];
        for(int k = 1; k < count.length; k++){
            if(count[k] > maxValue){
                maxValue = count[k];
            }
        }
        return maxValue;
    }

    //   10 2 9 3 9 4 9 5 9 6
    public int longestIncreasing() {
        int count[] = new int[data.length];
        for (int k = 0; k < count.length; k++) {
            count[k] = 1;
        }

        for(int i = 1 ; i < data.length; i++){
            for(int j = 0; j < i; j++){
               if(data[j] < data[i] && count[i] < count[j] + 1){
                   count[i] = count[j] + 1;
               }
            }
        }

        int maxValue = count[0];
        for(int k = 1; k < count.length; k++){
            if(count[k] > maxValue){
                maxValue = count[k];
            }
        }
        return maxValue;
    }

    public static void main(String args[]) {
        SequenceAlgorithms sq = new SequenceAlgorithms(new int[]{3, 4, 7, 0, 3, 9, 6});
        SequenceAlgorithms test = new SequenceAlgorithms(new int[]{1, 3, 6, 7, 7, 12, 15, 18, 19, 22, 5, 7, 10});
        System.out.println(sq.longestIncreasingContinuous());
        System.out.println(test.longestIncreasingContinuous());
        System.out.println(sq.longestIncreasing());
    }
}
