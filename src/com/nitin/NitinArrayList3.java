package com.nitin;

/**
 * Created by harash on 09/02/16.
 */
//constant Buffer
public class NitinArrayList3 {
    static final int BUFFER = 50;
    int length;
    String data[];

    public NitinArrayList3() {
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
}
