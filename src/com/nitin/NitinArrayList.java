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
public class NitinArrayList {
    static final int BUFFER = 50;
    String data[];
    int length;

    public NitinArrayList() {
        data = new String[BUFFER];
        length = 0;
    }

    public int length() {
        return data.length;
    }

    //    public void add(String s) {
//        if (length < data.length) {
//            data[length] = s;
//            length++;
//        } else {
//            // resize to data.length + BUFFER
//            String temp[] = new String[data.length + BUFFER];
//            for (int i = 0; i < data.length; i++) {
//                temp[i] = data[i];
//            }
//            data = temp;
//            data[length] = s;
//            length++;
//        }
    // create a new temporary array of length + 1
    // copy old array
    // set last element to s
    // replace data with temporary array
//}
//    public void add(String s){
//      String temp[] = new String[data.length+1];
//      for(int i = 0; i < data.length; i++){
//          temp[i] = data[i];
//      }
//        temp[length] = s;
//        data = temp;
//        length++;
//    }
    //Using dynamic buffer
    public void add(String s) {
        if (length < data.length) {
            data[length] = s;
            length++;
        } else {
            String temp[] = new String[data.length + 2 * BUFFER];
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
        int counter = 0;
        for (int i = 0; i < data.length; i++) {
            if (data.length == 0) {
                System.out.println("No elements");
            } else if (data[i].equals(s)) {
                data[i] = null;
                counter++;
            }
        }
        String temp[] = new String[data.length - counter];
        int k = 0;
        for (int j = 0; j < data.length; j++) {
            if (data[j] == null) {
                System.out.println("Do nothing");
            } else {
                temp[k] = data[j];
                k++;
            }
        }
        data = temp;
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

    public static void main(String args[]) {
        NitinArrayList n = new NitinArrayList();
        for (int i = 0; i < 50; i++) {
            n.add("nitin" + i);
        }
        n.remove("nitin1");
        n.remove("nitin2");
        n.remove("nitin3");

//        System.out.println(n.get(102));
//        System.out.println(n.get(34));
//        System.out.println(n.indexOf("nitin23"));
//        n.removeIndex(0);
//        n.remove("nitin");
        n.display();
        System.out.println(n.length);

    }
}