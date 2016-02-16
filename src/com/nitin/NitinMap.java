package com.nitin;

import java.util.ArrayList;

/**
 * Created by harash on 16/02/16.
 *
 * - Any datastructure you already know. ArrayList
 *
 *
 */
public class NitinMap {

    ArrayList<String> keys;
    ArrayList<String> values;

    public NitinMap() {
      keys = new ArrayList<String>();
      values = new ArrayList<String>();
    }

    public void put(String key, String value) {
         keys.add(key);
         values.add(value);
    }

    public void remove(String key) {
        values.remove(keys.indexOf(key));
        keys.remove(key);
    }

    public String get(String key) {
        if(exists(key)){
        return values.get(keys.indexOf(key));
        }else{
            throw new IllegalStateException("Key  not found");
        }
    }

    public boolean exists(String key) {
        int N = 0;
        while(N < keys.size()){
            if(keys.get(N).equals(key)){
                return true;
            }
            N++;
        }
        return false;
    }

    private static void myAssert(boolean condition) {
        if (!condition) throw new IllegalStateException("Something is wrong");
    }

    public static void main(String[] args) {
        // Test Driven Development.

        // Write at least 3 TEST CASES
        // Commit <code></code>
        // implement.
        NitinMap nm = new NitinMap();
        nm.put("Nitin","25");
        nm.put("harsh","30");
        System.out.println(nm.get("harsh"));
       // nm.remove("Nitin");

        nm.myAssert(nm.exists("Nitin"));
        nm.myAssert(nm.exists("harsh"));

        nm.remove("harsh");

        NitinMap map = new NitinMap();
        map.put("India", "7");
        map.put("USA", "1");
        map.put("Russia", "2");
        map.put("Germany" , "3");
        System.out.println(map.get("USA"));
        System.out.println(map.get("Germany"));
        System.out.println(map.get("India"));
        map.myAssert(map.exists("Germany"));
        map.myAssert(map.exists("India"));
      //  map.remove("USA");
        map.myAssert(map.exists("USA"));
        map.remove("India");
        map.remove("USA");
        map.remove("Russia");
        map.remove("Germany");

        for (int i = 0; i < 1000; i++){
            map.put("n"+i , "h"+i);
        }

        map.remove("n56");
        map.remove("n34");
        System.out.println(map.get("n58"));
        map.myAssert(map.exists("n99"));
        map.myAssert(map.exists("n999"));
    }

}
