package com.myoi.exer6;

import org.junit.Test;

import java.io.Serializable;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.*;

/**
 * @author myoi
 * @date 2021/12/14 - 10:28
 */
public class CollectionTest {


    @Test
    public void test2() {
        List coll= new ArrayList();
        coll.add("abc");
        //添加基本数据类型时，会自动装箱
        coll.add(123);
        coll.add(true);
        coll.set(0, "bbb");
        coll.add(2, "hello");
        coll.remove(new Integer(123));
        System.out.println(coll.get(0));
        System.out.println(coll);

    }

    @Test
    public void test1() {
        Collection coll= new ArrayList();
        LinkedList ll = new LinkedList();
        ll.add(13);

        coll.add("abc");
        //添加基本数据类型时，会自动装箱
        coll.add(123);
        coll.add(true);
        LocalDateTime now = LocalDateTime.now();
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
        String dateFormat = now.format(formatter);
        coll.add(dateFormat);
        System.out.println(coll);
        Iterator iterator = coll.iterator();
        while (iterator.hasNext()) {
            System.out.println(iterator.next());
        }



    }
}
