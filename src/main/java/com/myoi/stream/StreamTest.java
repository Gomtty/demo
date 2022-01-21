package com.myoi.stream;

import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

/**
 * @author myoi
 * @date 2021/12/20 - 14:50
 */
public class StreamTest {
    private List<Person> list = new ArrayList<>();

    public StreamTest() {
        list.add(new Person("jack", 19));
        list.add(new Person("wmw", 23));
        list.add(new Person("李四", 21));
        list.add(new Person("王五", 25));
        list.add(new Person("赵七", 22));
        list.add(new Person("张三", 30));
    }

    @Test
    public void test1() {
        list.stream().limit(2).forEach(System.out::println);
        System.out.println();
        list.stream().skip(2).forEach(System.out::println);
        System.out.println();
        list.add(new Person("oo", 30));
        list.add(new Person("oo", 30));
        list.add(new Person("oo", 30));
        list.stream().distinct().forEach(System.out::println);
    }

    @Test
    public void test3() {
//        List<Integer> ints = Arrays.asList(1,2,3,4,5);
//        Optional<Integer> reduce = ints.stream().reduce(Integer::sum);
//        System.out.println(reduce);
        List<Person> collect = list.stream().filter(p -> p.getAge() > 20).collect(Collectors.toList());
        System.out.println(collect);

//        strings.stream().map(str->str.toUpperCase()).forEach(System.out::println);
//        list.stream().map(Person::getName).filter(name -> name.length()>=3).forEach(System.out::println);

    }

    @Test
    public void test4() {
//        list.stream().sorted((p1, p2) -> -Integer.compare(p1.getAge(), p2.getAge()))
//                .forEach(System.out::println);
        boolean allMatch = list.stream().allMatch(p -> p.getAge() > 20);
        System.out.println(allMatch);
        boolean anyMatch = list.stream().anyMatch(p -> p.getName().equals("wmw"));
        System.out.println(anyMatch);
        Optional<Person> first = list.stream().findFirst();
        System.out.println(first);

    }

    @Test
    public void test2() {
        long count = list.stream().filter(p->p.getAge()>20).count();
        System.out.println(count);
        Optional<String> max = list.stream().map(Person::getName).max(String::compareTo);
        System.out.println(max);
        Optional<Person> min = list.stream().min((p1, p2) -> Integer.compare(p1.getAge(), p2.getAge()));
        System.out.println(min);
        list.forEach(System.out::println);
    }
}
