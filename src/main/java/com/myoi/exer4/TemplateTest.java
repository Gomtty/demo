package com.myoi.exer4;

import java.util.Calendar;

/**
 * @author myoi
 * @date 2021/12/8 - 13:21
 */
public class TemplateTest {

    public static void main(String[] args) {
        Calendar calendar=Calendar.getInstance();
        int i = calendar.get(Calendar.MONTH);
        System.out.println(i);
        Template template=new SubTemplate();
        template.spend();
    }

}

class SubTemplate extends Template{

    @Override
    public void code() {
        boolean flag;
        int count=0;
        for (int i = 2; i <= 1000; i++) {
            flag=false;
            for (int j = 2; j < Math.sqrt(i); j++) {
                if (i % j == 0) {
                    flag=true;
                    break;
                }
            }
            if (!flag) {
                count++;
            }
        }
        System.out.println(count);
    }
}

abstract class Template{

    //计算程序执行的时间
    public void spend() {
        long start= System.currentTimeMillis();
        code();
        long end= System.currentTimeMillis();
        System.out.println("程序执行时间为"+(end-start));
    }
    //易变的抽象方法
    public abstract void code();

}