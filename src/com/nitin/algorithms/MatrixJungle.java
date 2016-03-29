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
        int count[][] = new int[rows][columns];
        for(int i = 0; i < rows; i++){
            for(int j = 0; j < columns; j++){
                count[i][j] = countMaxStartingAt(i , j);
            }
        }
        int maxValue = count[0][0];
        for(int k = 0; k < rows; k++){
            for(int j = 0; j < columns; j++){
                if(count[k][j] > maxValue){
                    maxValue = count[k][j];
                }
            }
        }

        return maxValue;
    }

    // -> , ->
    private int countMaxStartingAt(int i, int j) {
        int countBottom = 0;
        int rowNumber = i;


        if (matrix[i][j] == false) {
            return 0;
        }
        while (rowNumber < rows && matrix[rowNumber][j] == true) {
            countBottom = countBottom + 1;
            rowNumber = rowNumber + 1;
        }
        int countPerRow[] = new int[countBottom];
        for (int m = 0; m < countPerRow.length; m++) {
            countPerRow[m] = 0;
        }
        for (int k = 0; k < countPerRow.length; k++) {
            int jCopy = j;
            while (jCopy < columns && i < rows && matrix[i][jCopy] == true) {
                countPerRow[k] = countPerRow[k] + 1;
                jCopy = jCopy + 1;
            }
            i = i + 1;
        }
        int min = countPerRow[0];
        for (int o = 0; o < countPerRow.length; o++) {
            if (countPerRow[0] != 0 && countPerRow[o] < min) {
                min = countPerRow[o];
            }
        }


        return countBottom * min;
    }

    private static void myAssert(boolean condition) {
        if (!condition) throw new IllegalStateException("Something is wrong");
    }

    public static void main(String args[]) {
        MatrixJungle jungle = new MatrixJungle(4, 4);
        jungle.set(0, 0, true);
        jungle.set(0, 1, true);
        jungle.set(0, 2, true);
        jungle.set(1, 0, true);
        jungle.set(1, 2, true);
        jungle.set(1, 3, true);
        jungle.set(2, 0, true);
        jungle.set(2, 1, true);
        jungle.set(2, 2, true);
        jungle.set(2, 3, true);
        jungle.set(3, 0, true);
        jungle.set(3, 2, true);
        jungle.set(3, 3, true);
        /*
          1 1 1 0
          1 0 1 1
          1 1 1 1
          1 0 1 1
         */

        myAssert(jungle.countMaxStartingAt(0, 0) == 4);
        myAssert(jungle.countMaxStartingAt(0, 1) == 2);
        myAssert(jungle.countMaxStartingAt(1 , 0) == 3);
        myAssert(jungle.countMaxStartingAt(1 , 2) == 6);
        myAssert(jungle.countMaxStartingAt(1 , 3) == 3);
        myAssert(jungle.countMaxStartingAt(2 , 1) == 3);
        myAssert(jungle.countMaxStartingAt(2 , 2) == 4);
        myAssert(jungle.countMaxStartingAt(2 , 3) == 2);
        myAssert(jungle.countMaxStartingAt(3 , 0) == 1);
        myAssert(jungle.countMax() == 6);

    }

}
