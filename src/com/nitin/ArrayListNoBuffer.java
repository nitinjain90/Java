package com.nitin;

/**
 * Created by harash on 09/02/16.
 */

//no buffer
public class ArrayListNoBuffer {

    String data[];
    int length;

    public ArrayListNoBuffer() {
        length = 0;
        data = new String[length];
    }

    public void add(String s) {
        String temp[] = new String[data.length + 1];
        for (int i = 0; i < data.length; i++) {
            temp[i] = data[i];
        }
        temp[length] = s;
        data = temp;
        length++;
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


    public static void main(String args[]) {
        ArrayListNoBuffer n = new ArrayListNoBuffer();
        for (int i = 0; i < 10000; i++) {
            n.add("" + i);
        }
        System.out.println(n.get(0));
        System.out.println(n.get(1));

        for (int j = 0; j < 10000; j = j + 2) {
            n.remove("" + j);
        }
        System.out.println(n.length);

        for (int k = 0; k < n.length; k++) {
            n.removeIndex(k);
        }
        System.out.println(n.length);

//        myAssert(n.length == 0);


//        n.add("Chunnu");
//        n.add("Hello World");
//        n.add("kill bill");
//        n.add("revenant");
//        n.add("sfdsf");
//
//        myAssert(n.indexOf("Chunnu") == 0);
//        n.remove("revenant");
//        myAssert(n.get(3) == "sfdsf");
//        myAssert(n.indexOf("kill bill") == 2);
//        n.removeIndex(2);
//        myAssert(n.indexOf("sfdsf") == 2);
//        myAssert(n.length == 3);
        //  myAssert(n.indexOf("revenant") == 2);


    }

}
