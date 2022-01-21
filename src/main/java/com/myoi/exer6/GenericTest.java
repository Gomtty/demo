package com.myoi.exer6;

import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;

/**
 * @author myoi
 * @date 2021/12/15 - 19:21
 */
public class GenericTest {

    @Test
    public void test1() {
        List<String> list1=new ArrayList<>();
        List<Object> list2=new ArrayList<>();
        list1.add("hello");
        list1.add("jack");
        list2.add(123);
        list2.add("nihao");
        print(list2);

    }

    public void print(List<?> list) {
        Iterator<?> iterator = list.iterator();
        while (iterator.hasNext()) {
            System.out.println(iterator.next());
        }
    }

}
