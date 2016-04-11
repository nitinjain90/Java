package com.nitin.algorithms;

import java.util.ArrayList;
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
    ArrayList<Point> visited = new ArrayList<Point>();


    class Point {
        int x;
        int y;

        public Point(int x, int y) {
            this.x = x;
            this.y = y;
        }

        @Override
        public boolean equals(Object obj) {
            Point p = (Point) obj;

            return p.x == x && p.y == y;
        }
    }

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
    public MatrixJungle(String s) {
        String rowsAsString[] = s.split("\n");
        String test[] = rowsAsString[0].split("\\s+");
        this.rows = rowsAsString.length;
        this.columns = test.length;
        matrix = new boolean[rows][columns];
        for (int i = 0; i < rowsAsString.length; i++) {
            String temp[] = rowsAsString[i].split("\\s+");
            for (int j = 0; j < columns; j++) {
                if (temp[j].equals("1")) {
                    matrix[i][j] = true;
                } else {
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
    public int count(int sx, int sy, int ex, int ey) {
        int count = 0;
        for (int i = sx; i <= ex; i++) {
            for (int j = sy; j <= ey; j++) {
                if (matrix[i][j] == true) {
                    count++;
                } else {
                    return 0;
                }
            }
        }

        return count;
    }

    public int countMax() {
        int max = Integer.MIN_VALUE;
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < columns; j++) {
                for (int k = 0; k < rows; k++) {
                    for (int l = 0; l < columns; l++) {
                        max = Math.max(max, count(i, j, k, l));
                    }
                }
            }
        }
        return max;
    }

    // -> , ->


    private int getBiggestRectangle(int n[]) {

        return 0;
    }

    public int shortestDistance(int sx, int sy, int ex, int ey) {
        int distance = Integer.MAX_VALUE;
        if (sx == ex && sy == ey) {
            return 0;
        }
        if (canMoveRight(sx, sy)) {
            visited.add(new Point(sx,sy));
            return 1 + shortestDistance(sx, sy + 1, ex, ey);
        }
        if (canMoveLeft(sx, sy)) {
            visited.add(new Point(sx,sy));
            return 1 + shortestDistance(sx, sy - 1, ex, ey);
        }
        if (canMoveUp(sx, sy)) {
            visited.add(new Point(sx,sy));
            return 1 + shortestDistance(sx - 1, sy, ex, ey);
        }
        if (canMoveDown(sx, sy)) {
            visited.add(new Point(sx,sy));
            return 1 + shortestDistance(sx + 1, sy, ex, ey);
        }

        return 0;
    }


    public int countIslands(String s) {
        return 0;
    }

    private boolean isIsland(int i, int j) {
        if (!canMoveRight(i, j) && !canMoveLeft(i, j) && !canMoveUp(i, j) && !canMoveDown(i, j)) {
            return true;
        } else {
            return false;
        }
    }

    private boolean canMoveRight(int i, int j) {
        if (j + 1 < columns && matrix[i][j + 1] == true && !hasVisitedRight(i , j)) {
            return true;
        } else {
            return false;
        }
    }

    private boolean canMoveLeft(int i, int j) {
        if (j - 1 >= 0 && matrix[i][j - 1] == true && !hasVisitedLeft(i , j)) {
            return true;
        } else {
            return false;
        }
    }

    private boolean canMoveUp(int i, int j) {
        if (i - 1 >= 0 && matrix[i - 1][j] == true && !hasVisitedUp(i , j)) {
            return true;
        } else {
            return false;
        }
    }

    private boolean canMoveDown(int i, int j) {
        if (i + 1 < rows && matrix[i + 1][j] == true && !hasVisitedDown(i , j)) {
            return true;
        } else {
            return false;
        }
    }

    private boolean hasVisitedDown(int i, int j) {
        return visited.contains(new Point(i + 1 , j));
    }
    private boolean hasVisitedUp(int i, int j) {
        return visited.contains(new Point(i - 1 , j));
    }
    private boolean hasVisitedRight(int i, int j) {
        return visited.contains(new Point(i , j + 1));
    }
    private boolean hasVisitedLeft(int i, int j) {
        return visited.contains(new Point(i, j - 1));
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


        MatrixJungle jungle2 = new MatrixJungle("1 1 1 1\n1 1 1 1\n1 0 1 1\n1 1 0 0");
        System.out.println(jungle2.countMax());
            /*
            1 0 0 0 1
            1 1 1 1 1
            1 1 1 1 0
            0 0 1 1 1
            1 1 1 1 1
             */

        MatrixJungle m3 = new MatrixJungle("1 0 1\n1 0 1");
        System.out.println(m3.countMax());
        MatrixJungle m4 = new MatrixJungle("1 1 1 1 0\n1 1 1 1 0\n1 0 1 1 0\n0 1 1 1 1\n0 0 1 0 1");
        System.out.println(m4.countMax());
        System.out.println(m3.shortestDistance(0, 0, 1, 2));
        System.out.println(m4.shortestDistance(0, 1, 2, 3));
    }

}
