package com.oop;

/**
 * Created by harsh on 1/27/16.
 */
public class FemalePerson extends Person {
    private boolean sexy;
    private int boobSize;
    private String[] dishes;

    @Override
    public String getSex() {
        return "female";
    }

    @Override
    public void run() {
        stop();
    }

    @Override
    public void stop() {

    }

    @Override
    public boolean isMoving() {
        return false;
    }

    @Override
    public int weight() {
        return 0;
    }

    @Override
    public int height() {
        return 0;
    }
}
