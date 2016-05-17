package com.nitin.acm;

import com.nitin.Utils;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

/**
 * Created by harash on 17/05/16.
 */
public class Problem103 {

    Map<Integer, ArrayList<String>> boxes;
    Utils utils = new Utils();
    public Problem103(String s){
        boxes = new HashMap<>();
        String str[] = s.split("\\n");
        int counter = 0;
        while(counter < str.length){
            String temp[] = str[counter].split("\\s+");
            int startIndex = counter + 1;
            int endIndex = startIndex + Integer.parseInt(temp[0]);
            ArrayList<String> list = new ArrayList<>();
            for(int i = startIndex; i < endIndex; i++){
                list.add(str[i]);
            }
            createMapEntry(str , startIndex , endIndex);
            counter = counter + Integer.parseInt(temp[0]) + 1;
         }
        utils.printMap(boxes);
    }

    private void createMapEntry(String s[] , int startIndex , int endIndex){
        ArrayList<String> str = new ArrayList<>();
        for(int i = startIndex; i <endIndex; i++){
            str.add(s[i]);
        }
        boxes.put(str.size() , str);
    }

    public static void main(String args[]) throws IOException {
        System.out.println("Enter input");
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String s = "";
        String str= "";
        while((s = br.readLine())!=null){
            str = str + s + "\n";
        }
        Problem103 test = new Problem103(str);
    }

}
