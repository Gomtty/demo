package com.myoi.exer6;

import org.junit.Test;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.*;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeFormatterBuilder;
import java.time.temporal.TemporalAccessor;
import java.util.Arrays;
import java.util.Comparator;
import java.util.Date;

/**
 * @author myoi
 * @date 2021/12/13 - 10:22
 */
public class LocalDateTimeTest {


    @Test
    public void test4() {
        String[] strs = {"aa", "cc", "bb"};
        Arrays.sort(strs);
        System.out.println(Arrays.toString(strs));
    }

    @Test
    public void test3() throws ParseException {
        String str = "2017-08-16";
        SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");
        Date parse = format.parse(str);
        java.sql.Date date = new java.sql.Date(parse.getTime());
        System.out.println(date);

    }

    @Test
    public void test2() {
        Instant now = Instant.now();
        System.out.println(now);
        OffsetDateTime offsetDateTime = now.atOffset(ZoneOffset.ofHours(8));
        System.out.println(offsetDateTime);
        System.out.println(now.toEpochMilli());
        System.out.println(System.currentTimeMillis());
    }

    @Test
    public void test1() {
        LocalDate now = LocalDate.now();
        LocalTime now1 = LocalTime.now();
        LocalDateTime now2 = LocalDateTime.now();
        System.out.println("**************");
        LocalDateTime dateTime = LocalDateTime.of(2020, 12, 31, 12, 12, 12);
        System.out.println("********");
        LocalDateTime dateTime1 = dateTime.plusDays(10);
        LocalDateTime dateTime2 = dateTime1.withDayOfMonth(20);
        LocalDateTime dateTime3 = dateTime.minusDays(10);

        System.out.println("****************");

    }


    @Test
    public void test5() {
        Person[] people = new Person[2];
        people[0]=new Person("wmw",20);
        people[1]=new Person("jack",22);
        Arrays.sort(people, new Comparator(){
            @Override
            public int compare(Object o1, Object o2) {
                if (o1 instanceof Person && o2 instanceof Person) {
                    Person p1=(Person) o1;
                    Person p2=(Person) o2;
                    if (p1.age > p2.age) {
                        return -1;
                    } else if (p1.age < p2.age) {
                        return 1;
                    } else {
                        return 0;
                    }
                }
                throw new RuntimeException("类型不匹配");
            }
        });
        System.out.println(Arrays.toString(people));
    }

}
class Person implements Comparable{
    String name;
    int age;

    public Person(String name, int age) {
        this.name = name;
        this.age = age;
    }

    @Override
    public int compareTo(Object o) {
        if (o instanceof Person) {
            Person p = (Person) o;
            return this.name.compareTo(p.name);
        }
        throw new RuntimeException("类型不匹配");
    }

    @Override
    public String toString() {
        return "Person{" +
                "name='" + name + '\'' +
                ", age=" + age +
                '}';
    }
}
