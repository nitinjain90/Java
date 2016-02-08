package com.oop;

/**
 * Created by harsh on 1/27/16.
 */
public abstract class Person implements Walkable, Measurable {
    private String name;
    private int age;

    public Person() {
        super();
    }

    public String getName() {
        return name;
    }

    public int getAge() {
        return age;
    }

    public void setName(String name) {
        System.out.println("Person:setName");
        this.name = name;
    }

    public void setAge(int age) {
        this.age = age;
    }

    @Override
    public void walk() {

    }

    @Override
    public void run() {

    }

    public abstract String getSex();
}
