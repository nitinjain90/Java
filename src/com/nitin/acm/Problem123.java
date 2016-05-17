package com.nitin.acm;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.lang.reflect.Array;
import java.util.*;

/**
 * Created by harash on 03/05/16.
 */
public class Problem123 {

    static Set<String> wordsToIgnore = new TreeSet<>();
    static ArrayList<String> sentences = new ArrayList<>();
    static Set<String> keywords = new TreeSet<>();

    private static void readInput() throws IOException {
        ArrayList<String> temp = new ArrayList<>();
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String s = "";
        while ((s = br.readLine()) != null) {
            temp.add(s.toLowerCase());
        }
        int n = temp.indexOf("::");
        for (int i = 0; i < n; i++) {
            wordsToIgnore.add(temp.get(i));
        }
        for (int j = n + 1; j < temp.size(); j++) {
            sentences.add(temp.get(j));
        }
        System.out.println(wordsToIgnore);
        System.out.println(sentences);
    }

    // Sentecens => keywords
    private static void extractKeywords() {
        for (int i = 0; i < sentences.size(); i++) {
            String[] temp = sentences.get(i).split("\\s");
            for (int j = 0; j < temp.length; j++) {
                if (!wordsToIgnore.contains(temp[j])) {
                    keywords.add(temp[j]);
                }
            }
        }
        System.out.println(keywords);
    }

    // a word is a god, word => a WORD is a god.
    private static void printSentence(String sentence, String word) {
       String[] temp = sentence.split("\\s");
       for(int i = 0; i < temp.length; i++){
           if (word.equals(temp[i])){
               System.out.print(word.toUpperCase());
           } else {
               System.out.print(temp[i]);
           }
           System.out.print(" ");
       }
        System.out.println();
    }

    private static void printLines() {

       for (Iterator<String> it = keywords.iterator(); it.hasNext();){
           String s = it.next();
           for(int j = 0; j < sentences.size(); j++){
               String temp[] = sentences.get(j).split("\\s");
               List<String> str = Arrays.asList(temp);
               if(str.contains(s)){
                   printSentence(sentences.get(j) , s);
               }
           }
       }
    }

    public static void main(String args[]) throws IOException {

        System.out.println("type simething");
        readInput();
        extractKeywords();
        printLines();

    }
}
