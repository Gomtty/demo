package com.myoi.exer6;

import org.junit.Test;

import java.util.Arrays;
import java.util.Comparator;

/**
 * @author myoi
 * @date 2021/12/13 - 13:26
 */
public class CompareTest {

    @Test
    public void test2() {
        String[] strs = new String[]{"aa", "cc", "dd", "bb"};
        Arrays.sort(strs, new Comparator(){
            @Override
            public int compare(Object o1, Object o2) {
                if (o1 instanceof String && o2 instanceof String) {
                    String s1=(String) o1;
                    String s2=(String) o2;
                    return -s1.compareTo(s2);
                }
                throw new RuntimeException("输入类型不匹配");
            }
        });
        System.out.println(Arrays.toString(strs));
    }

    @Test
    public void test1() {
        Goods[] gs=new Goods[3];
        gs[0]=new Goods("xiaomi", 20);
        gs[1]=new Goods("huawei", 30);
        gs[2]=new Goods("oppo", 25);

        Arrays.sort(gs);
        System.out.println(Arrays.toString(gs));

    }

}

class Goods implements Comparable{
    String name;
    double price;

    public Goods() {
    }

    public Goods(String name, double price) {
        this.name = name;
        this.price = price;
    }

    @Override
    public int compareTo(Object o) {
        if (o instanceof Goods) {
            Goods g=(Goods) o;
            if (this.price > g.price) {
                return 1;
            } else if (this.price < g.price) {
                return -1;
            } else {
                return this.name.compareTo(g.name);
            }
        }
        throw new RuntimeException("类型不一致，无法匹配");

    }

    @Override
    public String toString() {
        return "Goods{" +
                "name='" + name + '\'' +
                ", price=" + price +
                '}';
    }
}
