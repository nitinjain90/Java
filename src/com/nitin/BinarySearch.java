package com.nitin;

import java.util.ArrayList;
import java.util.Collections;

/**
 * Created by harash on 09/02/16.
 */
public class BinarySearch {
    ArrayList<Integer> list = new ArrayList<Integer>();

    public boolean search(ArrayList<Integer> list , int i){
        this.list = list;
        Collections.sort(list);
        return false;
    }
    public void add(int i){
        list.add(i);
    }


}
