package com.myoi.exer6;

import java.util.Comparator;
import java.util.TreeSet;

/**
 * @author myoi
 * @date 2021/12/15 - 10:40
 */
public class EmployeeTest {

    public static void main(String[] args) {
        Employee e1 = new Employee("wmw",22,new Mydate(1999,05,26));
        Employee e2 = new Employee("jack",23,new Mydate(1998,01,21));
        Employee e3 = new Employee("jf",21,new Mydate(2000,11,22));
        Employee e4 = new Employee("sr",22,new Mydate(1999,06,26));
        Employee e5 = new Employee("cl",25,new Mydate(1996,10,03));

        TreeSet set = new TreeSet();
        set.add(e1);
        set.add(e2);
        set.add(e3);
        set.add(e4);
        set.add(e5);
        for (Object e : set) {
            System.out.println(e);
        }

        Comparator com=new Comparator(){
            @Override
            public int compare(Object o1, Object o2) {
                if (o1 instanceof Employee && o2 instanceof Employee) {
                    Employee e1=(Employee) o1;
                    Employee e2=(Employee) o2;
                    Mydate birthday1 = e1.getBirthday();
                    Mydate birthday2 = e2.getBirthday();
                    int y = birthday1.getYear() - birthday2.getYear();
                    if (y != 0) {
                        return y;
                    }
                    int m = birthday1.getMonth() - birthday2.getMonth();
                    if (m != 0) {
                        return m;
                    }
                    return birthday1.getDay()- birthday2.getDay();

                }
                throw new RuntimeException("类型不一致");
            }
        };

        TreeSet treeSet = new TreeSet(com);
        treeSet.add(e1);
        treeSet.add(e2);
        treeSet.add(e3);
        treeSet.add(e4);
        treeSet.add(e5);
        System.out.println("****************");
        for (Object o : treeSet) {
            System.out.println(o);
        }

    }
}
