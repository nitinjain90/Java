package com.nitin;

import java.util.ArrayList;

/**
 * Created by harash on 16/02/16.
 * <p/>
 * - Any datastructure you already know. ArrayList
 */
public class NitinMap {

    ArrayList<String> keys;
    ArrayList<String> values;

    public NitinMap() {
        keys = new ArrayList<String>();
        values = new ArrayList<String>();
    }

    public void put(String key, String value) {
        // check for null
        // check for duplicate
        if (key.equals(null)) {
            throw new IllegalArgumentException("null value not allowed for key");
        }
        if (value.equals(null)) {
            throw new IllegalArgumentException("null values not allowed for value");
        }


        if (exists(key)) {
            values.set(keys.indexOf(key), value);
        } else {

            keys.add(key);
            values.add(value);
        }
    }

    public boolean isEmpty() {
        if (size() == 0)
            return true;
        else
            return false;
    }

    public void remove(String key) {
        values.remove(keys.indexOf(key));
        keys.remove(key);
    }

    public String get(String key) {
        if (!exists(key)) {
            throw new IllegalArgumentException("key not found");
        }
        return values.get(keys.indexOf(key));
    }

    public boolean exists(String key) {
        if(!keys.contains(key))
            return false;
        else
            return true;
    }

    public int size() {
        return keys.size();
    }

    private static void myAssert(boolean condition) {
        if (!condition) throw new IllegalStateException("Something is wrong");
    }

    public static void main(String[] args) {
        // Test Driven Development.

        // Write at least 3 TEST CASES
        // Commit <code></code>
        // implement.

        NitinMap map = new NitinMap();
        myAssert(map.isEmpty());
        map.put("nitin", "hello");
        map.put("chunnu", "hello world");
        map.put("India", "New Delhi");
        map.put("Sri Lanka", "Colombo");
        map.put("Pakistan", "Islamambad");
        map.put("Italy", "Rome");
        myAssert(!map.isEmpty());
        myAssert(map.get("nitin").equals("hello"));
        myAssert(map.get("India").equals("New Delhi"));
        myAssert(map.get("Italy").equals("Rome"));
        myAssert(!(map.get("chunnu").equals("hello")));

        myAssert(map.size() == 6);
        map.remove("nitin");
        myAssert(map.size() == 5);
        map.remove("chunnu");
        map.remove("India");
        myAssert(map.size() == 3);


        myAssert(map.exists("Sri Lanka"));
        myAssert(!map.exists("India"));
        myAssert(!map.exists("chunnu"));
        myAssert(map.exists("Italy"));

        map.put("", "Hello");
        myAssert(map.get("").equals("Hello"));
//        map.put("" , "kill bill");

        map.remove("");
        map.remove("Sri Lanka");
        map.remove("Pakistan");
        map.remove("Italy");

        myAssert(map.isEmpty());
        myAssert(map.size() == 0);
        myAssert(!map.exists("Italy"));


        map.put("Delhi", "NewDelhi");
        map.put("Delhi", "hall bol");
        myAssert(map.get("Delhi").equals("hall bol"));
        map.put("Rajasthan", "Jaipur");
        map.put("gujrat", "Ahemdabad");

        myAssert(map.size() == 3);
        myAssert(map.get("Delhi").equals("hall bol"));
        map.remove("Delhi");
        map.remove("Rajasthan");
        map.remove("gujrat");

        myAssert(map.size() == 0);

        map.put("hello", "");
        map.put("world", "");

        myAssert(map.get("hello").equals(""));
        myAssert(map.get("world").equals(""));

        map.put("hello", "");


//        map.put("Italy", "italy");
//         test(map);


    }


    public static void test(NitinMap m) {

        m.put("hello", null);

    }

}


// to add 100,000 - 53seconds
// to add 10,000 - 573 microseconds
