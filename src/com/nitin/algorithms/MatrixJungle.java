package com.nitin.algorithms;

import java.util.*;

/**
 * Created by harsh on 3/26/16.
 */
public class MatrixJungle {

    boolean matrix[][];
    int rows;
    int columns;


    class Point implements Comparable {
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

        @Override
        public int compareTo(Object o) {
            Point p = (Point) o;

            if (p.x == x && p.y == y) {
                return 0;
            } else
                return -1;
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

    int distanceRight = -1;
    int distanceLeft = -1;
    int distanceUp = -1;
    int distanceDown = -1;

    public int shortestDistance(Point start, Point end, Set<Point> visited) {

        if (start.equals(end)) {
            return 0;
        }
        if (isIsland(start)) {
            return Integer.MIN_VALUE;
        }
//        if(visited.contains(new Point(start.x, start.y + 1)) && visited.contains(new Point(start.x, start.y - 1)) && visited.contains(new Point(start.x + 1, start.y)) && visited.contains(new Point(start.x - 1, start.y))){
//            return Integer.MIN_VALUE;
//        }
        if (canMoveRight(start) && !visited.contains(new Point(start.x, start.y + 1))) {
            TreeSet<Point> temp = new TreeSet<>();
            temp.addAll(visited);
            temp.add(start);
            distanceRight = 1 + shortestDistance(new Point(start.x, start.y + 1), end, temp);
        }
        if (canMoveLeft(start) && !visited.contains(new Point(start.x, start.y - 1))) {
            TreeSet<Point> temp = new TreeSet<>();
            temp.addAll(visited);
            temp.add(start);
            distanceLeft = 1 + shortestDistance(new Point(start.x, start.y - 1), end, temp);
        }
        if (canMoveUp(start) && !visited.contains(new Point(start.x - 1, start.y))) {
            TreeSet<Point> temp = new TreeSet<>();
            temp.addAll(visited);
            temp.add(start);
            distanceUp = 1 + shortestDistance(new Point(start.x - 1, start.y), end, temp);
        }
        if (canMoveDown(start) && !visited.contains(new Point(start.x + 1, start.y))) {
            TreeSet<Point> temp = new TreeSet<>();
            temp.addAll(visited);
            temp.add(start);
            distanceDown = 1 + shortestDistance(new Point(start.x + 1, start.y), end, temp);
        }

        if (distanceDown >= 0 && distanceDown <= distanceLeft && distanceDown <= distanceUp && distanceDown <= distanceRight) {
            return distanceDown;
        } else if (distanceUp >= 0 && distanceUp <= distanceLeft && distanceUp <= distanceDown && distanceUp <= distanceRight) {
            return distanceUp;
        } else if (distanceRight >= 0 && distanceRight <= distanceLeft && distanceRight <= distanceUp && distanceRight <= distanceDown) {
            return distanceRight;
        } else if (distanceLeft >= 0 && distanceLeft <= distanceDown && distanceLeft <= distanceUp && distanceLeft <= distanceRight) {
            return distanceLeft;
        } else {
            return -1;
        }
    }

    public int shortestDistance(int sx, int sy, int ex, int ey) {
        Point start = new Point(sx, sy);
        Point end = new Point(ex, ey);
        return shortestDistance(start, end, new TreeSet<Point>());

    }


    public int countIslands(String s) {
        return 0;
    }

    private boolean isIsland(Point p) {

        if (!canMoveRight(p) && !canMoveLeft(p) && !canMoveUp(p) && !canMoveDown(p)) {
            return true;
        } else {
            return false;
        }
    }

    private boolean canMoveRight(Point p) {
        if (p.y + 1 < columns && matrix[p.x][p.y + 1] == true) {
            return true;
        } else {
            return false;
        }
    }

    private boolean canMoveLeft(Point p) {
        if (p.y - 1 >= 0 && matrix[p.x][p.y - 1] == true) {
            return true;
        } else {
            return false;
        }
    }

    private boolean canMoveUp(Point p) {
        if (p.x - 1 >= 0 && matrix[p.x - 1][p.y] == true) {
            return true;
        } else {
            return false;
        }
    }

    private boolean canMoveDown(Point p) {
        if (p.x + 1 < rows && matrix[p.x + 1][p.y] == true) {
            return true;
        } else {
            return false;
        }
    }


    private static void myAssert(boolean condition) {
        if (!condition) throw new IllegalStateException("Something is wrong");
    }


    public int possibleCombinations(String s){
        Set<String> total = new TreeSet<String>();
        

        return total.size();
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
