package com.myoi.service;

import org.junit.Test;

/**
 * @author myoi
 * @date 2021/12/13 - 16:51
 */
public class EnumTest {

    @Test
    public void test1() {
        Season summer = Season.SUMMER;
        System.out.println(summer);
        System.out.println(summer.getClass().getSuperclass());
    }
}

enum Season{

    SPRING("春天"),
    SUMMER("夏天"),
    AUTHOR("秋天"),
    WINTER("冬天");

    private final String name;

    private Season(String name) {
        this.name=name;
    }

    public String getName() {
        return name;
    }
}
