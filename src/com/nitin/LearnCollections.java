package com.nitin;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.*;

/**
 * Created by harsh on 1/25/16.
 * <p/>
 * List -> ArrayList, LinkedList
 * Set -> TreeSet, HashSet
 * Map -> TreeMap, HashMap
 */
public class LearnCollections {
      Comparator c = new Comparator() {
          @Override
          public int compare(Object o1, Object o2) {
              return 0;
          }
      };
      TreeMap m = new TreeMap(c);


    public static String readFileToString(String file) throws IOException {
        //String ret = "";
        // open FileInputStream
        // while loop
        // byte[]
        //ret += new String(b);
        String ret = "";
        FileInputStream fs = new FileInputStream(file);

        byte b[] = new byte[5];
        while (fs.read(b) != -1) {
            for (int i = 0; i < b.length; i++) {
                ret = ret + (char) b[i];
            }
        }

        return ret;
    }


    public static int countUniqueWordsInFile(String file) throws IOException {
        String temp = "";

        temp = readFileToString(file);
        String words[] = temp.split("\\s+");
        TreeSet<String> s = new TreeSet<String>();
        for (int i = 0; i < words.length; i++) {
            s.add(words[i]);
        }
        System.out.println(s.toString());
        // First read entire file to String
        // Create a function.

        // Use a SET
        return s.size();
    }

    public static void main(String[] args) throws IOException {
        LearnCollections c = new LearnCollections();
        int n = countUniqueWordsInFile("C:Users//Nitin/Desktop/nitin.txt");
        String s = readFileToString("C:/Users/Nitin/Desktop/nitin.txt");
        System.out.println(n);
    }

}
