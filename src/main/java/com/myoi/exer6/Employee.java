package com.myoi.exer6;

/**
 * @author myoi
 * @date 2021/12/15 - 10:37
 */
public class Employee implements Comparable<Employee>{

    private String name;
    private int age;
    private Mydate birthday;

    public Employee() {
    }

    public Employee(String name, int age, Mydate birthday) {
        this.name = name;
        this.age = age;
        this.birthday = birthday;
    }

//    @Override
//    public int compareTo(Object o) {
//        if (o instanceof Employee) {
//            Employee e = (Employee) o;
//            return this.name.compareTo(e.name);
//        }
//        throw new RuntimeException("类型不匹配");
//    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public Mydate getBirthday() {
        return birthday;
    }

    public void setBirthday(Mydate birthday) {
        this.birthday = birthday;
    }

    @Override
    public String toString() {
        return "Employee{" +
                "name='" + name + '\'' +
                ", age=" + age +
                ", birthday=" + birthday +
                '}';
    }

    @Override
    public int compareTo(Employee o) {
        return this.name.compareTo(o.name);
    }
}
