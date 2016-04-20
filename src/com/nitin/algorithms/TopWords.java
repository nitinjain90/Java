package com.nitin.algorithms;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.HashMap;
import java.util.TreeMap;

/**
 * Created by harash on 18/04/16.
 */
public class TopWords {

    public static void main(File file , int N) throws Exception {
        String fileContent = "";
        FileInputStream fi = new FileInputStream(file);
        byte b[] = new byte[5];
        int x = 0;
        while((x = fi.read(b)) != -1){
            for(int i = 0; i < x; i++){
                fileContent = fileContent + (char)b[i];
            }
        }
         TreeMap tm = new TreeMap();
        String words[] = fileContent.split("\\s+");
        for(int i = 0; i < words.length; i++){
            int count = 0;
            for(int j = 0; j<words.length; j++){
                if(words[i].equals(words[j])){
                    count++;
                }
            }
            tm.put(words[i] , count);
        }

    }
}
