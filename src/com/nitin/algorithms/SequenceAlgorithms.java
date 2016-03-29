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
        for(int k = 0; k < count.length; k++){
            count[k] = 1;
        }


        return 0;
    }

    //   10 2 9 3 9 4 9 5 9 6
    public int longestIncreasing() {
        int count[] = new int[data.length];
        for(int k = 0; k < count.length; k++){
            count[k] = 1;
        }
        for(int i = 0; i < data.length; i++){
            for(int j = i+1; j < data.length; j++){
                if(data[j] > data[i]){
                    count[i] = count[i] + 1;
                }
            }
        }
        int maxValue = count[0];
        for(int i = 0; i < count.length; i++){
            if(count[i] > maxValue){
                maxValue = count[i];
            }
        }

        return maxValue;
    }

    public static void main(String args[]){
        SequenceAlgorithms sq = new SequenceAlgorithms(new int[]{10 , 2 , 3 , 5 , 1 , 4 , 6 , 7 , 8 , 9 , 23 , 56});
        System.out.println(sq.longestIncreasingContinuous());
    }
}
