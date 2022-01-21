package com.myoi.exer4;

/**
 * @author myoi
 * @date 2021/12/8 - 12:53
 */
public class PersonTest {

    public static void main(String[] args) {
        Student student = new Student();
        method(student);
        System.out.println("-----------------");
        Person person=new Person(){
            @Override
            public void eat() {
                System.out.println("喜欢吃东西");
            }

            @Override
            public void breath() {
                System.out.println("喜欢呼吸");
            }
        };
        method(person);

        method(new Person(){
            @Override
            public void eat() {
                System.out.println("喜欢吃好吃东西");
            }

            @Override
            public void breath() {
                System.out.println("喜欢好好呼吸");
            }
        });
    }

    public static void method(Person person) {
        person.eat();
        person.breath();
    }
}

class Student extends Person{
    private int id;

    public Student() {
    }

    public Student(int age,String name,int id) {
        super(age, name);
        this.id=id;
    }

    public void eat() {
        System.out.println("学生好好吃东西");
    }

    public void breath() {
        System.out.println("学生好好呼吸");
    }
}

abstract class Person{
    private int age;
    private String name;

    public Person() {
    }

    public Person(int age, String name) {
        this.age=age;
        this.name=name;
    }

    public void eat() {
        System.out.println("人吃东西");
    }

    public void breath() {
        System.out.println("人呼吸");
    }

}