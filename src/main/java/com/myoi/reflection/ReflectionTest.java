package com.myoi.reflection;

import org.junit.Test;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.lang.reflect.Field;
import java.util.Properties;

/**
 * @author myoi
 * @date 2021/12/19 - 9:51
 */
public class ReflectionTest {

    @Test
    public void test3() throws Exception {
        Person person = new Person();
        person.gender='男';

        Class<Person> personClass = Person.class;
        for (Field field : personClass.getFields()) {
            System.out.println(field);
        }


    }

    public Object newInstance(String path) throws Exception {
        Class<Person> personClass = Person.class;
        Class<?> clazz = Class.forName(path);
        return clazz.newInstance();

    }

    @Test
    public void test2() throws Exception {
        Properties prop = new Properties();
        FileInputStream fis = new FileInputStream(new File("jdbc.properties"));
        prop.load(fis);
        String name = prop.getProperty("name");
        String gender = prop.getProperty("gender");
        System.out.println("name="+name+",gender="+gender);
    }

    @Test
    public void test1() throws Exception {
        Class<Person> personClass1 = Person.class;
        System.out.println(personClass1);
        Person person = new Person();
        Class<? extends Person> personClass2 = person.getClass();
        System.out.println(personClass2);
        Class<?> personClass3 = Class.forName("com.myoi.reflection.Person");
        System.out.println(personClass3);
        ClassLoader classLoader = ReflectionTest.class.getClassLoader();
        Class<?> personClass4 = classLoader.loadClass("com.myoi.reflection.Person");
        System.out.println(personClass4);

        System.out.println(personClass1==personClass2);
        System.out.println(personClass1==personClass3);
        System.out.println(personClass1==personClass4);
    }
}
