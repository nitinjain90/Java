package com.nitin;

import java.util.Objects;

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
        if(i >= length){
            throw new IllegalArgumentException(" Index Out of bounds");
        }

        String temp[] = new String[data.length - 1];

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
        int i = 0;
        int t = 0;
        while(i < length){
            if(Objects.equals(data[i] , s)){
                t = 1;
                i++;
                break;
            }else{
                i++;
            }

        }
        if(t == 0){
            throw new IllegalArgumentException("Element does not exist");
        }else {
            //element not found condition
            removeIndex(indexOf(s));
        }
    }

    public int size() {
        return length;
    }

    public int indexOf(String s) {
        int i = 0;
        while (i < length) {
            if (Objects.equals(data[i] , s)) {
                i = i + length;
                return (i - length);
            }
            i++;
        }

        return -1;
    }

    public String get(int i) {
        if(i >= length) {
            throw new IllegalArgumentException("Index out of bounds");
        }
        return data[i];
    }

    private static void myAssert(boolean condition) {
        if (!condition) throw new IllegalStateException("Something is wrong");
    }


    public static void main(String args[]) {
        ArrayListDynamic c = new ArrayListDynamic();

        c.add("hello");
        c.add("world");
        c.add("1234");
        c.add("chunnu");
        c.add("nitin");

        myAssert(c.get(0).equals("hello"));
        myAssert(c.get(1).equals("world"));
        myAssert(c.get(2).equals("1234"));

        myAssert(c.size() == 5);

        c.removeIndex(2);
        myAssert(c.get(2).equals("chunnu"));
        myAssert(c.get(3).equals("nitin"));
        myAssert(c.size() == (4));

        myAssert(c.indexOf("nitin") == 3);
        myAssert(c.indexOf("world") == 1);
        myAssert(c.indexOf("1234") == -1);


        c.remove("hello");
        c.remove("world");

        myAssert(c.size() == 2);
        myAssert(c.get(0).equals("chunnu"));
        myAssert(c.get(1).equals("nitin"));

        myAssert(c.indexOf("chunnu") == 0);
        myAssert(c.indexOf("nitin") == 1);

        myAssert(c.get(0).equals("chunnu"));
        myAssert(c.get(1).equals("nitin"));
        c.remove("chunnu");
        c.remove("nitin");
        myAssert(c.size() == 0);
        myAssert(c.indexOf("chunnu") == -1);
        myAssert(c.indexOf("nitin") == -1);


        c.add("mumbai");
        c.add("kolkata");
        c.add("chennai");
        c.add("blore");
        c.add("nagpur");

        myAssert(c.indexOf("mumbai") == 0);
        myAssert(c.indexOf("chennai") == 2);
        myAssert(c.indexOf("honululu") == -1);

        c.removeIndex(1);
        c.removeIndex(3);

        myAssert(c.indexOf("chennai") == 1);
        myAssert(c.indexOf("blore") == 2);
        myAssert(c.indexOf("nagpur") == -1);

        myAssert(c.size() == 3);
        c.remove("mumbai");
        c.remove("chennai");
        c.remove("blore");

        myAssert(c.size() == 0);
        // Corner Cases
        c.add(null);
        myAssert(c.indexOf(null) == 0);
        myAssert(c.size() == 1);
        c.removeIndex(0);
        myAssert(c.size() == 0);
        c.add(null);
        myAssert(c.indexOf(null) == 0);
        c.remove(null);
        myAssert(c.indexOf(null) == -1);
        myAssert(c.size() == 0);
        c.add("nitin");
        c.add("harsh");
        c.add("nitin");
        c.add("harsh");

        c.remove("nitin");
        c.remove("harsh");
        myAssert(c.indexOf("nitin") == 0);
        myAssert(c.indexOf("harsh") == 1);
        c.add("");
        myAssert(c.size() ==3);
        myAssert(c.indexOf("") == 2);
        myAssert(c.get(2).equals(""))  ;
        c.remove("");
        myAssert(c.size() == 2);
//        c.remove("Hello world");
//        c.removeIndex(25);


    }
}