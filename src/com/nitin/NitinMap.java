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
       // check for null
        // check for duplicate
        if(key !=null && value !=null && exists(key) == false) {
            keys.add(key);
            values.add(value);
        }
        else{
            throw new IllegalStateException("null values and duplicate entries not allowed");
        }
    }

    public boolean isEmpty(){
        if(size() == 0)
            return true;
            else
        return false;
    }

    public void remove(String key) {
        values.remove(keys.indexOf(key));
        keys.remove(key);
    }

    public String get(String key) {
        if(exists(key)){
        return values.get(keys.indexOf(key));
        }else{
            throw new IllegalStateException("Key not found");
        }
    }

    public boolean exists(String key) {
        int count = 0;
        int temp = 0;
        while(count < keys.size()){
            if(keys.get(count).equals(key)){
                temp = 1;
                count++;
                break;
            }else {
                count++;
            }
        }
        if(temp == 1)
            return true;
        else
        return false;
    }
    public int size(){
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
        map.put("nitin" , "hello");
        map.put("chunnu" , "hello world");
        map.put("India" , "New Delhi");
        map.put("Sri Lanka", "Colombo");
        map.put("Pakistan" , "Islamambad");
        map.put("Italy" , "Rome");
        myAssert(!map.isEmpty());
        myAssert(map.get("nitin") == "hello");
        myAssert(map.get("India") == "New Delhi");
        myAssert(map.get("Italy") == "Rome");
        myAssert(!(map.get("chunnu") == "hello"));

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

        map.put("" , "Hello");
        myAssert(map.get("") == "Hello");
//        map.put("" , "kill bill");

        map.remove("");
        map.remove("Sri Lanka");
        map.remove("Pakistan");
        map.remove("Italy");

        myAssert(map.isEmpty());
        myAssert(map.size() == 0);
        myAssert(!map.exists("Italy"));


        map.put("Delhi" , "NewDelhi");
        map.put("Rajasthan" , "Jaipur");
        map.put("gujrat" ,"Ahemdabad");

        myAssert(map.size() == 3);
        myAssert(map.get("Delhi") == "NewDelhi");
        map.remove("Delhi");
        map.remove("Rajasthan");
        map.remove("gujrat");

        myAssert(map.size() == 0);

        map.put("hello" , "");
        map.put("world" , "");

        myAssert(map.get("hello") == "");
        myAssert(map.get("world") == "");

        map.put("hello" , "");


//        map.put("Italy", "italy");
         test(map);



    }


    public static void test(NitinMap m){

        m.put("hello" , null);

    }

}


// to add 100,000 - 53seconds
// to add 10,000 - 573 microseconds
