package com.myoi.IO;

import org.junit.Test;

import java.io.IOException;
import java.io.RandomAccessFile;
import java.util.concurrent.locks.ReadWriteLock;

/**
 * @author myoi
 * @date 2021/12/18 - 9:42
 */
public class IOTest2 {

    @Test
    public void test2() {
        RandomAccessFile raf = null;
        try {
            raf = new RandomAccessFile("hello.txt", "rw");
            byte[] bytes = new byte[10];
            int len;
            raf.seek(5);
            StringBuilder builder = new StringBuilder();
            while ((len = raf.read(bytes)) != -1) {
                builder.append(new String(bytes, 0, len));
            }
            raf.seek(5);
            raf.write("jack".getBytes());
            raf.write(builder.toString().getBytes());
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            try {
                if (raf != null)
                    raf.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    @Test
    public void test1() {
        RandomAccessFile raf = null;
        try {
            raf = new RandomAccessFile("hello.txt", "rw");
            raf.write("abc".getBytes());
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            try {
                if (raf != null)
                    raf.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }

    }
}
