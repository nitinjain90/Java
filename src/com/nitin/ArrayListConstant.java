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
        String temp[] = new String[length - 1];

        for (int j = 0; j < i; j++) {
            temp[j] = data[j];
        }
        for (int k = i + 1; k < length; k++) {
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
        int i = 0;
        int t = 0;
        while(i < length){
            if(data[i].compareTo(s) == 0){
                t = 1;
                break;
            }
        }
        if(t == 0){
            System.out.println("Element does not exist");
        }else {

        }
    }

    public int size() {
        return length;
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
    }

    public static void main(String args[]) {
        ArrayListConstant c = new ArrayListConstant();
        c.add("hello");
        c.add("world");
        c.add("1234");
        c.add("chunnu");
        c.add("nitin");

        myAssert(c.get(0) == "hello");
        myAssert(c.get(1) == "world");
        myAssert(c.get(2) == "1234");

        myAssert(c.size() == 5);

        c.removeIndex(2);
        myAssert(c.get(2) == "chunnu");
//        c.remove("chunnu");
        myAssert(c.get(3) == "nitin");
        myAssert(c.size() == 4);

//        c.remove("1234");
//        c.remove("nitin");

//        myAssert(c.size() == 2);
//        myAssert(c.indexOf("chunnu") == 2);


//        c.remove("world");
//        c.remove("hello");

//        myAssert(c.indexOf("chunnu") == 1);

//        c.add("mumbai");
//        c.add("kolkata");
//        c.add("chennai");
//        c.add("blore");
//        c.add("nagpur");
//
//        myAssert(c.indexOf("mumbai") == 0);
//        myAssert(c.indexOf("chennai") == 2);
//        myAssert(c.indexOf("honululu") == -1);

    }

}
