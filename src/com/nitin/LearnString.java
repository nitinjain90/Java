package com.nitin;

import java.util.List;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Stack;
import java.util.regex.Pattern;

/**
 * Created by harsh on 1/25/16.
 */
public class LearnString {

    public static boolean isPalindrome(String s) {
        String temp = "";

        for (int i = s.length() - 1; i >= 0; i--) {
            temp = temp + s.charAt(i);
        }

        if (temp.compareToIgnoreCase(s) == 0) {
            return true;
        } else {
            return false;
        }
    }

    /**
     * ((fslkfjsdlfkds )
     * Use recursion. Remove correct matching expressions.
     * <p>
     * Use a stack (List)
     *
     * @param s
     * @return
     */
    public static boolean isProperExpression(String s) {
        /**
         * number of open braces= number of cold braces
         * no closed curly or square brace after
         *
         */
        Stack<Character> temp = new Stack<Character>();
        for (int i = 0; i < s.length(); i++) {
            char a = s.charAt(i);
            if (a == '(' || a == '{' || a == '[') {
                temp.add(a);
            } else if (a == ')' || a == '}' || a == ']') {
                //if the stack is empty return false
                if (temp.isEmpty())
                    return false;

                else if (a == ')' && temp.pop() != '(')
                    return false;
                else if (a == '}' && temp.pop() != '{')
                    return false;
                else if (a == ']' && temp.pop() != '[')
                    return false;

            }
        }
        //if the stack is empty then true else false
        if (temp.isEmpty())
            return true;
        else
            return false;
    }

    public static boolean isUpperCase(char c) {
        int valueofChar = c;
        if (valueofChar >= 65 && valueofChar <= 90) {
            return true;
        } else {

        }
        return false;
    }

    public static char toUpperCase(char c) {
        char converted = (char) (c - 32);
        return converted;
    }

    public static boolean isLowerCase(char c) {
        int valueofChar = c;

        return (valueofChar >= 97 && valueofChar <= 122);
    }

    /**
     * Java.util.Pattern
     * Google : Pattern Matching in Java
     */
    public static void studyRegex() {
        String s[] = {"__H__", "         ", "02183112484", "1201 USD", "Rs. 1,21,21", "4343-4565-4545-5544", "PHONE NUMBERS"};
        System.out.println(s[0].matches("\\D+H\\D+"));
        System.out.println(s[1].matches("\\s+"));
        System.out.println(s[2].matches("\\d+"));
        System.out.println(s[3].matches("\\d+\\sUSD"));
        System.out.println(s[4].matches("Rs.\\s(\\d+,)+\\d+"));
        System.out.println(s[5].matches("(\\d{4}-){3}+\\d{4}"));

    }

    /**
     * Multiple spaces => Single space.
     * Multiple newlines '\n' => Single New line.
     * First word after "." should be capitalized.
     * No word in middle of sentence should be capitalized
     */
    public static String properFormat(String s) {
        //removing spaces
        String[] lineRemoved = s.split("\\n+");
        String str = "";
        str = str + lineRemoved[0];
        for (int i = 1; i < lineRemoved.length; i++) {
            str = str + "\n" + lineRemoved[i];
        }
        String[] spaceRemoved = str.split("( )+"); // A      B
        String str1 = "";
        str1 = str1 + spaceRemoved[0];
        for (int i = 1; i < spaceRemoved.length; i++) {
            str1 = str1 + " " + spaceRemoved[i];
        }

        //every letter after "." should be capital
        //removing multiple new Lines
        //first a-z character after . should be capital
        //indexOf to find first a-z character in a string;

//        String[] makeCapital = str1.split("\\.");
//        String str2 = "";
//        System.out.println(makeCapital.length);
//        System.out.println(makeCapital[0].charAt(0));if (isLowerCase(makeCapital[0].charAt(0)))
//
//
//        for (int i = 0; i < makeCapital.length; i++) {
//            if (isLowerCase(makeCapital[i].charAt(0))) {
//                str2 = str2 + "." + toUpperCase(makeCapital[i].charAt(0)) + makeCapital[i].substring(1, makeCapital[i].length());
//            } else {
//                str2 = str2 + "." + makeCapital[i];
//            }
//        }


        return str1;

    }


    public static void main(String[] args) {

        System.out.println(isProperExpression("[{()}]"));
        System.out.println("hello world   \n  my name is.nitin \n\n\n hahahaha");
        System.out.println(properFormat("my name     is nitin jain.\n\n\ni am a good boy"));

    }
}
