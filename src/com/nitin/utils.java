package com.nitin;

import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;

/**
 * Created by harsh on 5/12/16.
 */
public class Utils {

    /**
     *
     *
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
        return null;
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
        Set<Map.Entry<String, Integer>> s =  m.entrySet();

    }

    public static void printList(List<Integer> l) {

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

}
