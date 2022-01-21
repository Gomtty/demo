package com.myoi.exer6;

import org.junit.Test;

import java.util.*;

/**
 * @author myoi
 * @date 2021/12/15 - 12:45
 */
public class HashMapTest {

    @Test
    public void test2() {
        Map map = new HashMap();
        map.put("张三", 10);
        map.put("李四", 60);
        map.put("杰克", 100);
        map.put("王五", 56);
        map.put("六六", 77);

        Set set = map.entrySet();
        List list = new ArrayList();
        list.addAll(set);
        Collections.sort(list, new Comparator() {
            @Override
            public int compare(Object o1, Object o2) {
                if (o1 instanceof Map.Entry && o2 instanceof Map.Entry) {
                    Map.Entry e1 = (Map.Entry) o1;
                    Map.Entry e2 = (Map.Entry) o2;
                    int v1 = (int) e1.getValue();
                    int v2 = (int) e2.getValue();
                    return -Integer.compare(v1, v2);
                }
                throw new RuntimeException("类型不匹配");
            }
        });
        for (int i = 0; i < 3; i++) {
            System.out.println(list.get(i));
        }

//        for (Object o : map.entrySet()) {
//            Map.Entry entry=(Map.Entry) o;
//            System.out.println(entry.getKey()+"="+entry.getValue());
//        }

    }

    @Test
    public void test1() {
        List list = new ArrayList();
        list.add(110);
        list.add(12);
        list.add(43);
        list.add(1);
        list.add(8);
        list.add(54);
        Collections.sort(list, new Comparator() {
            @Override
            public int compare(Object o1, Object o2) {
                if (o1 instanceof Integer && o2 instanceof Integer) {
                    Integer i1 = (Integer) o1;
                    Integer i2 = (Integer) o2;
                    return -Integer.compare(i1, i2);
                }
                throw new RuntimeException("类型不匹配");
            }
        });
        for (Object obj : list) {
            System.out.println(obj);
        }

    }
}
