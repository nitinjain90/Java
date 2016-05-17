package com.nitin.acm;

import com.nitin.Utils;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * Created by harash on 03/05/16.
 */
public class Problem100 {

    // 10 => "10 5 16 8 4 2 1"
    public static int combinations(int a) {
        int ret = 1;
        while (a != 1) {
            if (a % 2 == 0) {
                a = a / 2;
                ret++;
            } else {
                a = 3 * a + 1;
                ret++;
            }
        }
        return ret;
    }

    public static void maxCombinations(int a, int b) {
        int answer = Integer.MIN_VALUE;
        for (int i = a; i <= b; i++) {
            answer = Math.max(answer, combinations(i));
        }
        System.out.println(a + " " + b + " " + answer);
    }

    public static void main(String args[]) throws IOException {
//        if(args.length != 2){
//            throw new IllegalArgumentException("Need exact two arguments");
//        }
        //maxCombinations(Integer.parseInt(args[0]) , Integer.parseInt(args[1]));

        System.out.println("Enter two numbers with space");
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String s = "";
        while((s = br.readLine())!= null) {
            String numbers[] = s.split("\\s");
            int a = Integer.parseInt(numbers[0]);
            int b = Integer.parseInt(numbers[1]);
            maxCombinations(a, b);
        }
    }
}
