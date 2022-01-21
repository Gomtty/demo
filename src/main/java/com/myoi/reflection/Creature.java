package com.myoi.reflection;

/**
 * @author myoi
 * @date 2021/12/19 - 15:25
 */
public class Creature<T> {

    private String name;
    public int age;

    public Creature() {
    }

    private Creature(String name) {
        this.name=name;
    }

     Creature(String name, int age) {
        this.name = name;
        this.age = age;
    }
}
