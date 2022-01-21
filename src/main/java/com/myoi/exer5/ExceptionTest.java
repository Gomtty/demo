package com.myoi.exer5;

import org.junit.Test;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;

/**
 * @author myoi
 * @date 2021/12/9 - 12:36
 */
public class ExceptionTest {
    public static void main(String[] args) {
        ExceptionTest et = new ExceptionTest();
        try {
            et.method();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void method() throws IOException{
        test4();
    }

    public void test4() throws IOException {
        File file = new File("");
        FileInputStream fis = new FileInputStream(file);
        int data = fis.read();
        while (data != -1) {
            System.out.print((char) data);
            data = fis.read();
        }
        fis.close();
    }

    @Test
    public void test3() {
        FileInputStream fis = null;
        try {
            File file = new File(".txt");
            fis = new FileInputStream(file);
            int data = fis.read();
            while (data != -1) {
                System.out.print((char) data);
                data = fis.read();
            }
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            try {
                if (fis != null)
                    fis.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    @Test
    public void test2() {
        try {
            int a = 10;
            int b = 0;
            System.out.println(a / b);
        } catch (ArithmeticException e) {
            e.printStackTrace();
        }
        System.out.println("hello");
    }

    @Test
    public void test1() {
        String str = "123";
        try {
            char c = str.charAt(3);
        } catch (IndexOutOfBoundsException e) {
            e.printStackTrace();
        }
        System.out.println("hello");
    }
}
