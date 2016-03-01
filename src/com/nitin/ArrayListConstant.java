package com.nitin;

/**
 * Created by harash on 09/02/16.
 */
//constant Buffer
public class ArrayListConstant {
    static final int BUFFER = 50;
    int length;
    String data[];

    public ArrayListConstant() {
        length = 0;
        data = new String[BUFFER];
    }

    public void add(String s) {
        if (length < data.length) {
            data[length] = s;
            length++;
        } else {
            // resize to data.length + BUFFER
            String temp[] = new String[data.length + BUFFER];
            for (int i = 0; i < data.length; i++) {
                temp[i] = data[i];
            }
            data = temp;
            data[length] = s;
            length++;
        }
    }

    public void removeIndex(int i) {
        String temp[] = new String[data.length - 1];

        for (int j = 0; j < i; j++) {
            temp[j] = data[j];
        }
        for (int k = i + 1; k < data.length; k++) {
            temp[k - 1] = data[k];
        }

        data = temp;
        length--;
    }

    public void remove(String s) {
        /**
         * Go through array
         * Find the element
         * Set the element = null(Count the null elements)
         * Create a new array with size old - null
         * Copy the elements != null to a new array
         * Set the old array = new array
         */

        //element not found condition
        int counter = 0;
        for (int i = 0; i < length; i++) {
            if (data[i].compareTo(s) == 0) {
                data[i] = null;
                counter++;
            }
        }
        String temp[] = new String[data.length - counter];
        int k = 0;
        for (int j = 0; j < data.length; j++) {
            if (data[j] == null) {
//                System.out.println("Do nothing");
            } else {
                temp[k] = data[j];
                k++;
            }
        }
        data = temp;
        length = length - counter;
    }

    public int indexOf(String s) {
        int i = 0;
        while (i < length) {
            if (data[i].equals(s)) {
                i = i + length;
                return i - length;
            }
            i++;
        }

        return -1;
    }

    public String get(int i) {
        return data[i];
    }

    private static void myAssert(boolean condition) {
        if (!condition) throw new IllegalStateException("Something is wrong");
        else
            System.out.println("Correct");
    }

    public static void main(String args[]){

    }

}
