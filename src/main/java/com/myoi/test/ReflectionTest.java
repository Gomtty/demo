package com.myoi.test;

import com.myoi.reflection.Person;
import org.junit.Test;

import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.lang.reflect.Modifier;

/**
 * @author myoi
 * @date 2021/12/19 - 15:27
 */
public class ReflectionTest {

    @Test
    public void test3() throws Exception {
        Class<Person> personClass = Person.class;
        Field num = personClass.getDeclaredField("num");
        num.set(personClass, 100);
        System.out.println(num.get(personClass));
        Constructor<Person> constructor = personClass.getDeclaredConstructor();
        Person person = constructor.newInstance(null);
        person.id=10;
        System.out.println(person);
    }

    @Test
    public void test2() throws Exception {
        Class<Person> personClass = Person.class;
        Person person = personClass.newInstance();
        Field id = personClass.getDeclaredField("weight");
        id.setAccessible(true);
        id.set(person,1001);
        System.out.println(id.get(person));
    }

    @Test
    public void test1() {
        Class<Person> personClass = Person.class;
        for (Field f : personClass.getDeclaredFields()) {
            int modifiers = f.getModifiers();
            System.out.println(Modifier.toString(modifiers)+":"+f.getType()+":"+f.getName());
        }
        System.out.println();

        for (Method m : personClass.getDeclaredMethods()) {
            System.out.println(Modifier.toString(m.getModifiers())+":"+m.getReturnType()+":"+m.getParameterTypes()+":"+m.getName());
        }

        System.out.println();
        for (Constructor<?> constructor : personClass.getDeclaredConstructors()) {
            System.out.println(constructor);
        }


    }
}
