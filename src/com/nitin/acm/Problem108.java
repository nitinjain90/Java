package com.nitin.acm;

import com.nitin.Utils;

import java.util.Arrays;

/**
 * Created by harsh on 5/12/16.
 */
public class Problem108 {


    public static int[][] parseInput(String s) {
        String str[] = s.split("\\s+");
        int N = Integer.parseInt(str[0]);
        int counter = 1;
        int matrix[][] = new int[N][N];
        for (int i = 0; i < N; i++){
            for(int j = 0; j < N; j++){
                matrix[i][j] = Integer.parseInt(str[counter]);
                counter++;
            }
        }
            return matrix;
    }



    public static void main(String args[]) {
        Utils utils = new Utils();

        int[][] test =  parseInput("4\n" +
                "0 -2 -7  0 9  2 -6  2\n" +
                "-4  1 -4  1 -1\n" +
                "8  0 -2");
        utils.printMatrix(test);

    }

}
