package com.nitin.acm;

import com.nitin.Utils;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by harash on 17/05/16.
 */
public class Problem103 {
    //  3 5
    //  4 3
    class Box {
        final int index;
        final int dimensions[];

        public Box(int index, String s) {

        }

        public boolean canGoInside(Box b) {
            return false;
        }
    }

    private final List<Box> boxes;

    public Problem103(int N, int D, String[] s){

    }
    
    public static void main(String args[]) throws IOException {
        System.out.println("Enter input");
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String s = "";
        while((s = br.readLine()) != null){
            String sp[] = s.split(" ");
            int N = Integer.parseInt(sp[0]);
            int D = Integer.parseInt(sp[1]);

            String inputs[] = new String[N];
            for (int i = 0; i < N; i++) {
                inputs[i] = br.readLine();
            }

            Problem103 problem = new Problem103(N, D, inputs);
        }
    }

}
