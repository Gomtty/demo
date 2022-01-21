package com.myoi.exer5;

import org.junit.Test;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * @author myoi
 * @date 2021/12/12 - 17:47
 */
public class SimpleDateFormatTest {


    @Test
    public void test1() throws ParseException {
        String str = "2021-01-11";
        String str2 = "2021-01-01";
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
        Date date1 = sdf.parse(str);
        Date date2 = sdf.parse(str2);
        long l = date1.getTime() - date2.getTime();
        long days = (l / (1000 * 60 * 60 * 24) + 1) % 5;
        int day = Integer.parseInt(days + "");
        switch (day) {
            case 1:
                System.out.println("打鱼");
                break;
            case 2:
                System.out.println("打鱼");
                break;
            case 3:
                System.out.println("打鱼");
                break;
            case 4:
                System.out.println("晒网");
                break;
            case 0:
                System.out.println("晒网");
                break;

        }


    }
}
