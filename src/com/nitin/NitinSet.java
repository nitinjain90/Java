package com.nitin;

/**
 * Created by harsh on 1/25/16.
 * <p>
 * V1 : Do naive implementation.
 * V2 : Using binary search
 * <p>
 * Performance Analysis.
 */
public class NitinSet {

    private String data[];
    int length;
    static final int BUFFER = 50;

    public NitinSet() {
        data = new String[BUFFER];
        length = 0;
    }

    public void add(String s) {
        if (exists(s) || s == null) {
            System.out.println("Sorry cannot add already prsent");
        } else if (length < data.length) {
            data[length] = s;
            length++;
        } else {
            String temp[] = new String[data.length + BUFFER];
            for (int i = 0; i < data.length; i++) {
                temp[i] = data[i];
            }
            data = temp;
            data[length] = s;
            length++;
        }
    }


    public void remove(String s) {
        // 0 elements
        // if element not found.
        int index = 0;
        if(!exists(s)){
          System.out.println("Element not present");
        }
        if(length == 0){
            System.out.println("Nothing to remove");
        }
        else {
            for(int i = 0; i < data.length; i++){
                if(data[i] == s){
                    index = i;
                }
            }
            String temp[] = new String[data.length-1];
            for(int j = 0; j < index; j++){
                temp[j] = data[j];
            }
            for(int k = index+1; k < data.length; k++){
                temp[k -1] = data[k];
            }
            data= temp;
            length= length -1;
        }

    }

    public boolean exists(String s) {
        boolean result = false;
        int i = 0;
        if (length == 0)
            result = false;
        else {
            while (i < length) {
                if (data[i].equals(s)) {
                    result = true;
                    break;
                }
                i++;
            }
        }
        return result;
    }

    public int length() {
        return data.length;
    }

    public void display() {
        for (int i = 0; i < data.length; i++) {
            System.out.println(data[i]);
        }
    }

    public static void main(String args[]) {
        NitinSet n = new NitinSet();
        long startTime = System.nanoTime();
        for (int i = 0; i < 100000; i++) {
            n.add("hello" + i);
        }
        long endTime = System.nanoTime();
        System.out.println("Time taken = "+(endTime - startTime)/1000000000+"s");

//        n.add("wow");
//        n.add(null);
////        for(int j = 0; j < 10000; j++){
//            n.remove("hello" +j);
//            System.out.println(n.length());
//        }
//        n.remove("ki");

    }
}
//458ms