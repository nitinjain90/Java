package com.nitin;

/**
 * Created by harsh on 1/25/16.
 * <p/>
 * V1 : Do naive implementation.
 * V2 : Homework
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
        if (exists(s)) {
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

    }

    public String get(int i) {
        return data[i];
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
        for (int i = 0; i < 25; i++) {
            n.add("nitin" + i);
        }

        n.display();
    }
}