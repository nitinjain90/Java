package com.nitin.acm;

import com.nitin.Utils;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * Created by harsh on 5/12/16.
 */
public class Problem108 {

    int matrix[][];
    int rows;
    int columns;


    public Problem108(String s) {
        String str[] = s.split("\\s+");
        int counter = 1;
        rows = Integer.parseInt(str[0]);
        columns = rows;
        matrix = new int[rows][columns];
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < columns; j++) {
                matrix[i][j] = Integer.parseInt(str[counter]);
                counter++;
            }
        }
    }


    public int count(int sx, int sy, int ex, int ey) {
        int sum = 0;
        for (int i = sx; i <= ex; i++) {
            for (int j = sy; j <= ey; j++) {
                sum = sum + matrix[i][j];
            }
        }
        return sum;
    }

    public int maxSum() {
        int maxSum = Integer.MIN_VALUE;
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < columns; j++) {
                for (int k = i; k < rows; k++) {
                    for (int l = j; l < columns; l++) {
                        maxSum = Math.max(maxSum, count(i, j, k, l));
                    }
                }
            }
        }

        return maxSum;
    }

    public static void main(String args[]) throws IOException {
       System.out.println("Please input in proper format");
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String s = "";
        String str = "";
        while((s = br.readLine())!= null){
            str = str + s;
        }
        System.out.println(new Problem108(str).maxSum());
    }

}
