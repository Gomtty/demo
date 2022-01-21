package com.myoi.exer4;

/**
 * @author myoi
 * @date 2021/12/8 - 16:45
 */
public interface CompareObject {

    int compareTo(Object obj);

    public default void getA() {
        System.out.println("nihao");
    }
}
