package com.myoi.exer3;

import org.junit.Test;

/**
 * @author myoi
 * @date 2021/12/7 - 10:05
 */
public class WrapperTest {

    @Test
    public void test1() {
        int num1=10;
//        Integer int10 = new Integer(num1);
        Integer i1=num1;//自动装箱
        int int1=i1;//自动拆箱
        float f1=12.3f;
        double d1=12.3;
        String str1 = String.valueOf(f1);
        System.out.println(str1);
        String str2 = String.valueOf(d1);
        System.out.println(str2);

    }
}
