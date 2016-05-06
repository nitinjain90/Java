package com.nitin.algorithms;

import java.util.ArrayList;
import java.util.Set;
import java.util.TreeSet;

/**
 * Created by harash on 03/05/16.
 */
public class SearchingQuickly {

    Set<String> wordsToIgnore;
    ArrayList<String> sentences;
    Set<String> keywords;

    private void readInput() {

    }

    // Sentecens => keywords
    private void extractKeywords() {

    }

    // a word is a god, word => a WORD is a god.
    private static void printSentence(String sentence, String word) {

    }

    private static void printLines() {
        for (String keyword : keywords) {
            for (String sentence : sentences) {
                if (sentence.indexOf(keyword) >= 0) {
                    printSentence(sentence, word);
                }
            }
        }
    }

    public static String printTitles(String s){
        ArrayList<String> wordsToIgnore = new ArrayList<>();
        ArrayList<String> otherStrings = new ArrayList<>();
        ArrayList<String> keywords = new ArrayList<>();
        int value = 0;
        String[] temp = s.split("\\n");
        int i = 0;
        while(!temp[i].equals("::")){
            wordsToIgnore.add(temp[i]);
            i++;
            value = i;

        }
        System.out.println(wordsToIgnore);
        for(int j = value + 1; j < temp.length; j++){
            otherStrings.add(temp[j]);
        }
        Set<String> keys = new TreeSet<>();
        for(int  k = 0; k < otherStrings.size(); k++){
            String[] t = otherStrings.get(k).split("\\s");
            for(int l = 0; l < t.length; l++){
                if(!wordsToIgnore.contains(t[l])){
                    keys.add(t[l]);
                }
            }
        }
        System.out.println(otherStrings);
        System.out.println(keys);

        return "";
    }

    public static void main(String args[]) {
        readInput();
        System.out.println(wordsToIgnore);

        printTitles("is\n" +
               "the\n" +
               "of\n" +
               "and\n" +
               "as\n" +
               "a\n" +
               "but\n" +
               "::\n" +
               "Descent of Man\n" +
               "The Ascent of Man\n" +
               "The Old Man and The Sea\n" +
               "A Portrait of The Artist As a Young Man\n" +
               "A Man is a Man but Bubblesort IS A DOG");
    }
}
