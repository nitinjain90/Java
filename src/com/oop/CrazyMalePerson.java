package com.oop;

/**
 * Created by harsh on 1/27/16.
 */
public class CrazyMalePerson extends MalePerson {

    @Override
    public void stop() {
        int r = (int) (Math.random() * 100);
        if (r < 50){
            super.stop();
        }
    }
}
