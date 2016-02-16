package com.nitin;

/**
 * Created by harash on 09/02/16.
 */

//no buffer
public class NitinArrayList2 {

    String data[];
    int length;

    public NitinArrayList2() {
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

}
