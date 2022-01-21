package com.myoi.reflection;

/**
 * @author myoi
 * @date 2021/12/19 - 9:51
 */
public class Person extends Creature<String> implements Comparable<String>{

    public int id;
    private double weight;
    char gender;

    public static int num=10;


    public Person() {
    }



    private Person(int id, double weight, char gender) {
        this.id = id;
        this.weight = weight;
        this.gender = gender;
    }

    public Person(String name, int age, int id, double weight, char gender) {
        super(name, age);
        this.id = id;
        this.weight = weight;
        this.gender = gender;
    }


    public void show() {
        System.out.println("我是Person");
    }

    private void hello() {
        System.out.println("HelloWorld");
    }

    @Override
    public int compareTo(String o) {
        return 0;
    }

    @Override
    public String toString() {
        return "Person{" +
                "id=" + id +
                ", weight=" + weight +
                ", gender=" + gender +
                '}';
    }
}
