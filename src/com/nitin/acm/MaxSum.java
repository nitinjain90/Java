package com.nitin.acm;

import com.nitin.Utils;

import java.util.Arrays;

/**
 * Created by harsh on 5/12/16.
 */
public class MaxSum {

    int matrix[][];
    int rows;
    int columns;



    public MaxSum(String s) {
        String str[] = s.split("\\s+");
        int counter = 1;
        rows = Integer.parseInt(str[0]);
        columns = rows;
        matrix = new int[rows][columns];
        for(int i = 0; i < rows; i++){
            for(int j = 0; j < columns; j++){
                matrix[i][j] = Integer.parseInt(str[counter]);
                counter++;
            }
        }
    }


    public int count(int sx, int sy , int ex, int ey){
        int sum = 0;
        for(int i = sx; i <= ex; i++){
            for(int j = sy; j <= ey; j++){
                sum = sum + matrix[i][j];
            }
        }

        return sum;
    }

    public int maxSum(){
        int maxSum = Integer.MIN_VALUE;
        for(int i = 0; i < rows; i++){
            for(int j = 0; j < columns; j++){
                for(int k = 0; k < rows; k++){
                    for(int l = 0; l < columns; l++){
                        maxSum = Math.max(maxSum , count(i , j , k , l ));
                    }
                }
            }
        }

        return maxSum;
    }

    public static void main(String args[]) {
        Utils utils = new Utils();
        MaxSum  sum = new MaxSum("4\n" +
                "0 -2 -7  0 9  2 -6  2\n" +
                "-4  1 -4  1 -1\n" +
                "8  0 -2");
        System.out.println(sum.maxSum());

    }

}
