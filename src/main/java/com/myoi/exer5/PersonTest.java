package com.myoi.exer5;

import java.util.Objects;

/**
 * @author myoi
 * @date 2021/12/9 - 9:17
 */
public class PersonTest {

    public static void main(String[] args) {
        Person person = new Person();//非静态内部类-创建对象
        Person.Dog dog = person.new Dog();

        Person.Cat cat = new Person.Cat();//静态内部类-创建对象
    }
}
class Person{
    private int age;
    private String name="杰克";

    static class Cat{
        private int age;
        private String name;

        public Cat() {
        }
    }
    class Dog{
        private String name="花花";
        private int age;

        public Dog() {
        }

        public void show(String name) {
            System.out.println(name);
            System.out.println(this.name);
            System.out.println(Person.this.name);
        }
    }

    public Person() {
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Person person = (Person) o;
        return age == person.age && Objects.equals(name, person.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(age, name);
    }
}
