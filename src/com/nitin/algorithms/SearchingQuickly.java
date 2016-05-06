package com.nitin.algorithms;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Set;
import java.util.TreeSet;

/**
 * Created by harash on 03/05/16.
 */
public class SearchingQuickly {

    static Set<String> wordsToIgnore;
    static ArrayList<String> sentences;
    static Set<String> keywords;

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
           if(word.equals(temp[i])){
               temp[i] = temp[i].toUpperCase();
           }
       }
        String s = "";
        for(int i = 0; i < temp.length; i++){
            s = s + " "+temp[i];
        }
        System.out.println(s);
    }

    private static void printLines() {
        
    }

    public static String printTitles(String s) {
        ArrayList<String> wordsToIgnore = new ArrayList<>();
        ArrayList<String> otherStrings = new ArrayList<>();
        ArrayList<String> keywords = new ArrayList<>();
        int value = 0;
        String[] temp = s.split("\\n");
        int i = 0;
        while (!temp[i].equals("::")) {
            wordsToIgnore.add(temp[i]);
            i++;
            value = i;

        }
        System.out.println(wordsToIgnore);
        for (int j = value + 1; j < temp.length; j++) {
            otherStrings.add(temp[j]);
        }
        Set<String> keys = new TreeSet<>();
        for (int k = 0; k < otherStrings.size(); k++) {
            String[] t = otherStrings.get(k).split("\\s");
            for (int l = 0; l < t.length; l++) {
                if (!wordsToIgnore.contains(t[l])) {
                    keys.add(t[l]);
                }
            }
        }
        System.out.println(otherStrings);
        System.out.println(keys);

        return "";
    }

    public static void main(String args[]) throws IOException {

       printSentence("hello world" , "world");
//        System.out.println("type simething");
//        readInput();
//        extractKeywords();

    }
}
