package com.myoi.exer;

/**
 * @author myoi
 * @date 2021/12/4 - 12:52
 */
public class Person {
    private String name;
    private int age;

    public Person() {
        System.out.println("1111111111111111");
    }

    public Person(int age) {
        this();
        this.age=age;
    }

    public Person(String name,int age) {
        this(age);
        this.name=name;
    }

    public void setName(String name) {
        this.name=name;
    }

    public void setAge(int age) {
        this.age=age;
    }

    public String getName() {
        return name;
    }

    public int getAge() {
        return age;
    }
}
