package com.nitin;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

/**
 * Created by harsh on 5/12/16.
 */
public class Utils {

    /**
     * @return
     */
    public static String[] readCommandLine() {
        return null;
    }

    /**
     * a,b,c,d,e,f,,,,,,g => [a,b,c,d,e,g]
     * a::b::c::d::e::g => [a,b,c,d,e,g]
     *
     * @param s
     * @param separator
     * @return
     */
    public static String[] splitString(String s, String separator) {
        String result[] = s.split(separator);
        List<String> list = new ArrayList<>();
        for (int i = 0; i < result.length; i++) {
            String str = result[i];
            if (str.length() > 0) {
                list.add(str);
            }
        }
        return list.toArray(new String[]{});
    }

    // Using Iterators => List/Set
    public static void removeAllInstancesOf(List<Integer> l, int x) {
        Iterator<Integer> iter = l.iterator();
        while (iter.hasNext()) {
            int v = iter.next();
            if (v == x) {
                iter.remove();
            }
        }
    }

    public static void printArray(int N[]){
        for(int i = 0; i < N.length; i++){
            System.out.print(N[i] + " ");
        }
    }

    public static void printMap(Map<Integer, ArrayList<String>> m) {
        Set<Map.Entry<Integer, ArrayList<String>>> s = m.entrySet();
        for (Iterator<Map.Entry<Integer, ArrayList<String>>> itr = s.iterator(); itr.hasNext(); ) {
            Map.Entry<Integer, ArrayList<String>> temp = itr.next();
            System.out.println(temp.getKey() + " ," + temp.getValue());
        }
    }

    public static void printList(List<Integer> l) {
        System.out.println(l);
    }

    public static void printMatrix(int matrix[][]) {
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[i].length; j++) {
                System.out.print(matrix[i][j] + " ");
            }
            System.out.println();
        }
    }


    public static void removeWrongly(List<Integer> l, int x) {
        // Why will this code not work ? TODO :- Homework. Find atleast 2 examples where this code will not work and
        // explain why ?
        for (int i = 0; i < l.size(); i++) {
            int v = l.get(i);
            if (v == x) {
                l.remove(i);
            }
        }
    }

    public static String parseInput() throws IOException {
        System.out.println("Enter Input");
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String s = "";
        String str = "";
        while((s = br.readLine()) != null){
            str = str + s;
        }

        return null;
    }

    // 1 << 2 ==> 100
    // 1 << 1 =>

    // 1101010001101 & 00000001000 => 00000000000


    // "ABCD" => 2 * 2 * 2 *2 => 2^N
    public static List<String> allCombinations(String word, int N) {
        List<String> ret = new ArrayList<>();
        for (int i = 1; i <= Math.pow(2, word.length()); i++) {

            String out = "";
            for (int j = 0; j < word.length(); j++) {
                if ((i & (1 << j)) == (1 << j)) {
                    out = out + word.charAt(j);
                }
            }
            if (out.length() == N) {
                ret.add(out);
            }
        }

        return null;
    }

    // Binary representation.
    // 1 = 01
    // 2 = 10
    // 3 = 11
    // 4 = 100

      // Reason : After removing first "1" the value of i increments to 1 but the second "1" is at index 0 hence it is not removed
      // and this method fails.

    public static void main(String args[]) {
        String s = "a,b,c,d,e,f,,,,,,g";
        System.out.println(Arrays.asList(splitString(s, "\\W")));
//      Map<String , Integer> map = new HashMap<>();
//        map.put("helllo", 1);
//        map.put("hel", 2);
//        map.put("hell", 3);
//        map.put("hello", 4);
//
//      printMap(map);

        List<Integer> list = new ArrayList<>();
        list.add(1);
        list.add(1);
        list.add(3);
        list.add(4);
        list.add(2);
        list.add(1);

        removeWrongly(list, 1);
        System.out.println(list);
    }


}
