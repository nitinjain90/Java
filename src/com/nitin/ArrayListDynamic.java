package com.nitin;

/**
 * Created by harsh on 1/25/16.
 * <p/>
 * this only has strings.
 * <p/>
 * V1 :- Simple algo.
 * V2 :- Use a buffer
 * V3 :- Using dynamic buffer. Start with 10, on every resize increase size by 2X.
 */

//Using Dynamic buffer
public class ArrayListDynamic {
    static final int BUFFER = 50;
    String data[];
    int length;

    public ArrayListDynamic() {
        data = new String[BUFFER];
        length = 0;
    }

    public int length() {
        return data.length;
    }

    public void add(String s) {
        if (length < data.length) {
            data[length] = s;
            length++;
        } else {
            String temp[] = new String[data.length * 2];
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
        --length;
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

    public void display() {
        for (int i = 0; i < data.length; i++) {
            System.out.println(data[i]);
        }
    }

    private static void myAssert(boolean condition) {
        if (!condition) throw new IllegalStateException("Something is wrong");
        else
            System.out.println("Correct");
    }

    public static void main(String args[]) {
        ArrayListDynamic n = new ArrayListDynamic();

        for(int i = 0; i < 10000; i++){
            n.add(""+i);
        }
        System.out.println(n.get(0));
        System.out.println(n.get(1));

        for(int j  = 0 ; j < 10000; j++){
            n.remove(""+j);
        }
        System.out.println(n.length);

//        for(int k = 0; k < n.length; k++){
//            n.remove(n.get(k));
//        }
//        System.out.println(n.length);



//        n.add("nitin");
//        n.add("nitin");
//        n.add("harsh");
//        n.add("harsh");
//
//        n.removeIndex(1);
//        n.removeIndex(3);
//        myAssert(n.length == 2);
//        myAssert(n.get(0) == "nitin");
//        myAssert(n.get(1) == "harsh");
//        n.remove("nitin");
//        n.remove("harsh");

//        myAssert(n.length == 0);
//        n.add(null);
//        n.add(null);
//        n.add(null);
//
//      n.remove(null);
//        for(int i = 0; i < 10000; i++){
//            n.add(""+i);
//        }
//        System.out.println(n.get(0));
//        System.out.println(n.get(1));
//
//        for(int j  = 0 ; j < 10000; j= j+2){
//            n.remove(""+j);
//        }
//        System.out.println(n.length);
//
//
//        System.out.println(n.indexOf("3"));
//        System.out.println(n.indexOf("1"));
//
//        myAssert(n.get(0).equals("1"));
//        myAssert(n.get(1).equals("3"));
//        myAssert(n.get(2).equals("5"));
//
//        System.out.println(n.get(0));
//        System.out.println(n.get(1));
//        System.out.println(n.get(2));
//        System.out.println(n.get(3));
//        System.out.println(n.get(4));
//
//
//        n.add(null);
//      n.remove(null);
//        n.add("nitin");
//        n.add("Harsh");
//        myAssert(n.indexOf("nitin") == 0);
//        myAssert(n.indexOf("Harsh") == 1);
//        myAssert (n.indexOf("not exist") == -1);
//       // myAssert (n.indexOf("nitin") == 1);
//
//        n.add("chunnu");
//        n.add("sheldon");
//        myAssert(n.indexOf("chunnu") == 2);
//        myAssert(n.indexOf("sheldon") == 3);
//        n.add("hello world");
//
//        myAssert(n.length == 5);
//        n.remove("chunnu");
//        myAssert(n.indexOf("chunnu") == -1);
//        myAssert(n.length == 4);
//        myAssert(n.indexOf("sheldon") == 2);
//        myAssert(n.indexOf("hello world") == 3);
//        System.out.println(n.length);
//        myAssert(n.get(3) == "hello world");
//        myAssert(n.get(2) == "sheldon");
//        myAssert(n.get(1) == "Harsh");

    }
}