package com.myoi.Team.domain;

/**
 * @author myoi
 * @date 2021/12/9 - 15:19
 */
public class Employee {
    private int id;
    private String name;
    private double salary;
    private int age;

    public Employee() {

    }

    public Employee(int id, String name, double salary, int age) {
        this.id = id;
        this.name = name;
        this.salary = salary;
        this.age = age;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public double getSalary() {
        return salary;
    }

    public void setSalary(double salary) {
        this.salary = salary;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }


    public String getDetails() {
        return id + "\t\t" + name + "\t\t" + age + "\t\t" + salary;
    }
    @Override
    public String toString() {
        return getDetails();
    }
}
