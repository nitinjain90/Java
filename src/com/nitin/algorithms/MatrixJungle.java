package com.nitin.algorithms;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

/**
 * Created by harsh on 3/26/16.
 */
public class MatrixJungle {

    boolean matrix[][];
    int rows;
    int columns;

    /**
     * Initialize matrix to all false elements.
     *
     * @param rows
     * @param columns
     */
    public MatrixJungle(int rows, int columns) {
        this.rows = rows;
        this.columns = columns;
        matrix = new boolean[rows][columns];
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < columns; j++) {
                matrix[i][j] = false;
            }
        }
    }
    //
    public MatrixJungle(String s){
       String rowsAsString[] = s.split("\n");
       String test[] = rowsAsString[0].split("\\s+");
       this.rows = rowsAsString.length;
       this.columns = test.length;
       matrix = new boolean[rows][columns];
       for(int i = 0; i < rowsAsString.length; i++){
           String temp[] = rowsAsString[i].split("\\s+");
           for(int j = 0; j < columns; j++){
               if(temp[j].equals("1")){
                   matrix[i][j] = true;
               }else{
                   matrix[i][j] = false;
               }
           }
       }


    }

    public void set(int row, int column, boolean value) {
        matrix[row][column] = value;
    }

    /**
     * 0 1 0 0 1
     * 1 1 0 0 0
     * 1 1 0 0 0
     * 0 0 0 0 0
     *
     * @return
     */
    public int countMax() {
        int maxValue = Integer.MIN_VALUE;
        for(int i = 0; i < rows; i++){
            for(int j = 0; j < columns; j++){
                maxValue = Math.max(maxValue , countMaxStartingAt(i , j));
            }
        }
        return maxValue;
    }

    // -> , ->
    private int countMaxStartingAt(final int i, final int j) {
        if(matrix[i][j] == false){
            return 0;
        }
        int xStart = i;
        int yStart = j;
        int countBottom = 0;
        while(xStart < rows && matrix[xStart][yStart] == true){
            countBottom = countBottom + 1;
            xStart = xStart + 1;
        }
        int rowCount[] = new int[countBottom];
        for(int mI = 0; mI < rowCount.length; mI++){
            rowCount[mI] = 1;
        }
        xStart = i;
        yStart = j;
        for(int mi = i; mi < i + countBottom; mi++){
            for(int mj = j + 1; mj < columns; mj++){
                if(matrix[mi][mj] == true){
                    rowCount[mi-i] = rowCount[mi-i] + 1;
                }else{
                    break;
                }
            }
        }


        return 0;
    }
    private int getBiggestRectangle(int n[]){

        return 0;
    }


    public int shortestDistance(int sx , int sy , int ex, int ey){

        return -1;
    }
    public int countIslands(String s){
        return 0;
    }
    private static void myAssert(boolean condition) {
        if (!condition) throw new IllegalStateException("Something is wrong");
    }

    public static void main(String args[]) {
        MatrixJungle jungle = new MatrixJungle("1 0 1\n1 1 1\n0 1 0");
        myAssert(jungle.matrix[0][0] == true);
        myAssert(jungle.matrix[0][1] == false);
        myAssert(jungle.matrix[0][2] == true);
        myAssert(jungle.matrix[1][0] == true);
        myAssert(jungle.matrix[1][1] == true);
        myAssert(jungle.matrix[1][2] == true);
        myAssert(jungle.matrix[2][0] == false);
        myAssert(jungle.matrix[2][1] == true);
        myAssert(jungle.matrix[2][2] == false);
        myAssert(jungle.rows == 3);
        myAssert(jungle.columns == 3);
        System.out.println(jungle.countMax());

        MatrixJungle jungle2 = new MatrixJungle("1 1 1 1\n1 1 1 1\n1 0 1 1\n1 1 0 0");
        System.out.println(jungle2.countMax());

            /*
            1 0 0 0 1
            1 1 1 1 1
            1 1 1 1 0
            0 0 1 1 1
            1 1 1 1 1
             */

    }

}
