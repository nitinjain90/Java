package com.nitin.acm;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * Created by harsh on 5/6/16.
 */
public class Problem100 {

    public static void main(String[] args) throws IOException {
        System.out.println("Hello");

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String s = null;
        while ((s = br.readLine()) != null) {
            System.out.println(s);
        }
    }
}
