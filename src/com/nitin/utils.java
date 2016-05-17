package com.nitin;

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

    public static void printMap(Map<String, Integer> m) {
        Set<Map.Entry<String, Integer>> s = m.entrySet();
        for (Iterator<Map.Entry<String, Integer>> itr = s.iterator(); itr.hasNext(); ) {
            Map.Entry<String, Integer> temp = itr.next();
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
