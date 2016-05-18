package com.nitin.acm;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * Created by harash on 17/05/16.
 */
public class Problem103 {
    //  3 5
    //  4 3
    static class Box {
        final int index;
        final int dimensions[];

        public Box(int index, String s) {
            String temp[] = s.split("\\s");
            this.index = index;
            dimensions = new int[temp.length];
            for(int i = 0; i < dimensions.length; i++){
                dimensions[i] = Integer.parseInt(temp[i]);
            }
        }

        public boolean canGoInside(Box b) {
            if(b.dimensions.length!= dimensions.length)
                return false;
            ArrayList<Integer> list1 = new ArrayList<>();
            ArrayList<Integer> list2 = new ArrayList<>();
            for(int i = 0; i < dimensions.length; i++){
                list1.add(dimensions[i]);
                list2.add(b.dimensions[i]);
            }
            Collections.sort(list1);
            Collections.sort(list2);

            for(int j = 0; j < list1.size(); j++){
                if(list1.get(j) > list2.get(j))
                    return false;
            }

            //sort both dimensions in ascending order and compare every dimension.

            return true;
        }
    }

    private final List<Box> boxes;

    public Problem103(int N, int D, String[] s){
          boxes = new ArrayList<>();

    }
    
    public static void main(String args[]) throws IOException {
//        System.out.println("Enter input");
//        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
//        String s = "";
//        while((s = br.readLine()) != null){
//            String sp[] = s.split(" ");
//            int N = Integer.parseInt(sp[0]);
//            int D = Integer.parseInt(sp[1]);
//
//            String inputs[] = new String[N];
//            for (int i = 0; i < N; i++) {
//                inputs[i] = br.readLine();
//            }
//
//            Problem103 problem = new Problem103(N, D, inputs);
//        }
      Box box1 = new Box(1 , "2 7 3 5");
      Box box2 = new Box(2 , "1 6 2 3");
        System.out.println(box2.canGoInside(box1));

    }

}
