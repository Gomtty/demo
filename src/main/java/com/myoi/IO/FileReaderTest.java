package com.myoi.IO;

import org.junit.Test;

import java.io.*;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;

/**
 * @author myoi
 * @date 2021/12/16 - 16:32
 */
public class FileReaderTest {

    @Test
    public void test8() {
        FileReader fr = null;
        FileWriter fw = null;
        try {
            fr = new FileReader(new File(""));
            fw = new FileWriter(new File(""));
            char[] chars = new char[10];
            int len;
            Map<Character, Integer> map = new HashMap<>();
            char c;
            while ((len = fr.read(chars)) != -1) {
                for (int i = 0; i < len; i++) {
                    c = chars[i];
                    if (map.containsKey(c)) {
                        Integer count = map.get(c);
                        map.put(c, ++count);
                    } else {
                        map.put(c, 1);
                    }
                }
            }
            fw.write(map.toString());
            for (Map.Entry<Character, Integer> entry : map.entrySet()) {
                System.out.println(entry.getKey() + "=" + entry.getValue());
            }

        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            try {
                if (fr != null)
                    fr.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
            try {
                if (fw != null)
                    fw.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }

    }

    //异或加密
    @Test
    public void test7() {
        BufferedInputStream bis = null;
        BufferedOutputStream bos = null;
        try {
            bis = new BufferedInputStream(new FileInputStream(new File(".jpg")));
            bos = new BufferedOutputStream(new FileOutputStream(new File("e2.jpg")));
            byte[] bytes = new byte[20];
            int len;
            while ((len = bis.read(bytes)) != -1) {
                //异或加密
                for (int i = 0; i < len; i++) {
                    bytes[i] = (byte) (bytes[i] ^ 5);
                }
                bos.write(bytes, 0, len);
            }
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            try {
                if (bos != null)
                    bos.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
            try {
                if (bis != null)
                    bis.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }


    }


    public void copyBufferedRW(String srcPath, String destPath) {
        BufferedReader br = null;
        BufferedWriter bw = null;
        try {
            br = new BufferedReader(new FileReader(new File(srcPath)));
            bw = new BufferedWriter(new FileWriter(new File(destPath)));
            char[] chars = new char[10];
            int len;
            while ((len = br.read(chars)) != -1) {
                bw.write(chars, 0, len);
            }
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            try {
                if (bw != null)
                    bw.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
            try {
                if (br != null)
                    br.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }

    }


    @Test
    public void test6() {
        String srcPath = "C:\\Users\\wmw96\\Desktop\\新建文本文档.txt";
        String destPath = "C:\\Users\\wmw96\\Desktop\\新建文本文档1.txt";
        long start = System.currentTimeMillis();
        copyBufferedRW(srcPath, destPath);
        long end = System.currentTimeMillis();
        System.out.println("花费时间为：" + (end - start));


    }

    /**
     * @Description: 使用缓冲流读写
     * @Param: [srcPath, destPath]
     * @ParamType: [java.lang.String, java.lang.String]
     * @Return: void
     * @Author: myoi
     * @Date: 2021/12/16 - 20:26
     */
    public void copyBuffered(String srcPath, String destPath) {
        BufferedInputStream bis = null;
        BufferedOutputStream bos = null;
        try {
            //1创建文件对象
            File inputFile = new File(srcPath);
            File outputFile = new File(destPath);
            //2创建流对象
            //文件流
            FileInputStream fis = new FileInputStream(inputFile);
            FileOutputStream fos = new FileOutputStream(outputFile);
            //缓冲流
            bis = new BufferedInputStream(fis);
            bos = new BufferedOutputStream(fos);
            //3读写
            byte[] bytes = new byte[1024];
            int len;
            while ((len = bis.read(bytes)) != -1) {
                bos.write(bytes, 0, len);
            }
        } catch (IOException e) {
            e.printStackTrace();
        } finally {

            //4流资源的关闭
            //缓冲流的资源关闭会默认关闭 内层文件流资源
            try {
                if (bos != null)
                    bos.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
            try {
                if (bis != null)
                    bis.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }


    /**
     * @Description: 使用文件流复制文件
     * @Param: [srcPath, destPath]
     * @ParamType: [java.lang.String, java.lang.String]
     * @Return: void
     * @Author: myoi
     * @Date: 2021/12/16 - 19:56
     */
    public void copy(String srcPath, String destPath) {
        FileInputStream fis = null;
        FileOutputStream fos = null;
        try {
            //1、获取文件对象
            File inputFile = new File(srcPath);
            File outputFile = new File(destPath);
            //2、创建流对象
            fis = new FileInputStream(inputFile);
            fos = new FileOutputStream(outputFile);
            //3、读入、写出
            //一次读取1024个字节
            byte[] bytes = new byte[1024];
            int len;
            while ((len = fis.read(bytes)) != -1) {
                fos.write(bytes, 0, len);
            }
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            //4、流资源的关闭
            try {
                if (fis != null)
                    fis.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
            try {
                if (fos != null)
                    fos.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    //使用字节流图片的读入和写出
    @Test
    public void test5() {
        String srcPath = "C:\\Users\\wmw96\\Desktop\\01.函数.mp4";
        String destPath = "C:\\Users\\wmw96\\Desktop\\02.函数.mp4";
        long start = System.currentTimeMillis();
        copy(srcPath, destPath);
        long end = System.currentTimeMillis();
        System.out.println("花费时间为：" + (end - start));//花费时间为：4412


    }

    //以下均为字符流 处理文本类型的文件

    //文本读入和写出
    @Test
    public void test4() {
        //2、创建流对象
        FileReader fr = null;
        FileWriter fw = null;
        try {
            //1、创建文件对象
            File inputFile = new File("xt");
            File outputFile = new File("txt");
            fr = new FileReader(inputFile);
            fw = new FileWriter(outputFile);
            //一次读取 n个字符，存到字符数组中
            char[] chars = new char[5];
            //获取读取到的字符个数
            int len;
            //当读取到的字符个数为-1是，表示已经读完所有字符，循环结束
            while ((len = fr.read(chars)) != -1) {
                fw.write(chars, 0, len);

            }
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            try {
                //流资源的关闭
                if (fw != null)
                    fw.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
            try {
                if (fr != null)
                    fr.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }


    }

    //写出
    @Test
    public void test3() {
        FileWriter fw = null;
        try {
            File file = new File("txt");
            fw = new FileWriter(file);
            fw.write("你啊");
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            try {
                if (fw != null)
                    fw.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }


    }


    //读入
    @Test
    public void test2() {
        FileReader fr = null;
        try {
            File file = new File("ho.txt");
            fr = new FileReader(file);
            char[] chars = new char[5];
            int len;
            while ((len = fr.read(chars)) != -1) {
                for (int i = 0; i < len; i++) {
                    System.out.print(chars[i]);
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            try {
                if (fr != null)
                    fr.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    @Test
    public void test1() {
        FileReader fr = null;
        try {
            File file = new File("helo.txt");
            fr = new FileReader(file);
            int data;
            while ((data = fr.read()) != -1) {
                System.out.print((char) data);
            }
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            try {
                if (fr != null)
                    fr.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }


    }
}
