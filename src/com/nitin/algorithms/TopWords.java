package com.nitin.algorithms;

import javax.swing.text.html.HTMLDocument;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.*;

/**
 * Created by harash on 18/04/16.
 */
public class TopWords {

    static class WordNumber implements Comparable {
        String word;
        int number;

        public WordNumber(String word, int number) {
            this.word = word;
            this.number = number;
        }

        @Override
        public int compareTo(Object o) {
            WordNumber wn = (WordNumber) o;
            if (wn.number > number)
                return 1;
            else if (wn.number < number)
                return -1;
            else
                return 0;
        }
    }


    public static void topWords(String file, int N) throws Exception {
        String fileContent = "";
        FileInputStream fi = new FileInputStream(file);
        byte b[] = new byte[5];
        int x = 0;
        while ((x = fi.read(b)) != -1) {
            for (int i = 0; i < x; i++) {
                fileContent = fileContent + (char) b[i];
            }
        }
        TreeMap tm = new TreeMap();
        String words[] = fileContent.split("\\s+");
        ArrayList<WordNumber> list = new ArrayList<>();
        for (int i = 0; i < words.length; i++) {
            int count = 0;
            for (int j = 0; j < words.length; j++) {
                if (words[i].equals(words[j])) {
                    count++;
                }
            }
            tm.put(words[i], count);
        }
        Set set = tm.keySet();
        for(Iterator i = set.iterator(); i.hasNext();){
            String key = (String)i.next();
            int value = (Integer)tm.get(key);
            list.add(new WordNumber(key , value));
        }

        Collections.sort(list);

        for(int i = 0; i < N ; i++){
            System.out.println(list.get(i).word+"-"+list.get(i).number);
        }
    }

    public static void main(String args[]) throws Exception {
        if (args.length < 2) {
            throw new IllegalArgumentException("Need atleast two arguments");
        }
        topWords(args[0], Integer.parseInt(args[1]));
    }
}
