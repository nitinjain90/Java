package com.oop;

/**
 * Created by harsh on 1/27/16.
 */
public class MalePerson extends Person {
    private String jobTitle;
    private int salary;


    @Override
    public String getSex() {
        return "male";
    }

    @Override
    public void walk() {
        run();
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
