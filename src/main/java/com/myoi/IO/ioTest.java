package com.myoi.IO;

import org.junit.Test;

import java.io.*;
import java.time.LocalDateTime;

/**
 * @author myoi
 * @date 2021/12/16 - 12:21
 */
public class ioTest {


    //反序列化 ，把对象从磁盘文件中加载到内存
    @Test
    public void test7() {
        ObjectInputStream ois = null;
        try {
            ois = new ObjectInputStream(new FileInputStream("obdat"));
            Object o = ois.readObject();
            System.out.println(o);
        } catch (IOException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } finally {
            try {
                if (ois != null)
                    ois.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }

    }


    //序列化 把对象持久化到磁盘
    @Test
    public void test6() {

        ObjectOutputStream oos = null;
        try {
            oos = new ObjectOutputStream(new FileOutputStream("obdat"));

            oos.writeObject(new Person("伍某人",22));
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            try {
                if (oos != null)
                    oos.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }


    }

    public static void main(String[] args) {

        String str = "";
        while (true) {
            str = Myinput.readString();
            if ("exit".equalsIgnoreCase(str)) {
                break;
            }
            System.out.println(str.toUpperCase());
        }
        Myinput.close();
//        BufferedReader br = null;
//        try {
//            InputStreamReader isr = new InputStreamReader(System.in);
//            br = new BufferedReader(isr);
//            String str;
//            while (true) {
//                System.out.println("请输入字符串（e或exit退出）：");
//                str = br.readLine();
//                if ("e".equalsIgnoreCase(str) || "exit".equalsIgnoreCase(str)) {
//                    break;
//                }
//                System.out.println(str.toUpperCase());
//            }
//        } catch (IOException e) {
//            e.printStackTrace();
//        } finally {
//            try {
//                if (br != null)
//                    br.close();
//            } catch (IOException e) {
//                e.printStackTrace();
//            }
//        }
    }

    @Test
    public void test5() {


    }


    @Test
    public void test4() throws IOException {
        File file1 = new File("hello.txt");
        File file2 = new File("hello1.txt");
        FileInputStream fis = new FileInputStream(file1);
        FileOutputStream fos = new FileOutputStream(file2);
        InputStreamReader isr = new InputStreamReader(fis, "utf-8");
        OutputStreamWriter osw = new OutputStreamWriter(fos, "gbk");
        char[] chars = new char[10];
        int len;
        while ((len = isr.read(chars)) != -1) {
            osw.write(chars, 0, len);
        }

        osw.close();
        isr.close();
    }

    @Test
    public void test1() throws IOException {
        File file = new File("D:\\io\\file");
        File file1 = new File(file, "");
        if (!file.exists()) {
            System.out.println(file.mkdirs());
        }
        if (!file1.exists()) {
            System.out.println(file1.createNewFile());
        } else {
            file1.delete();
        }
    }

    @Test
    public void test2() {
        File file = new File("D://my");
        if (file.exists()) {
            for (String s : file.list()) {
                if (s.endsWith(".jpg")) {
                    System.out.println(s);
                }
            }
        }
    }

    @Test
    public void test3() {
        File file = new File("D:\\platform-tools（黑域ADB）");
        print(file);
        System.out.println(length);
    }

    private static int length = 0;

    public void print(File file) {
        if (file.isDirectory()) {
            for (File f : file.listFiles()) {
                System.out.println(f);
            }
            for (File f : file.listFiles()) {
                print(f);
            }
        } else {
            length += file.length();
        }
    }

}

class Person implements Serializable{

    public static final long serialVersionUID = -4897984223367710L;

    private String name;
    private int age;

    public Person() {
    }

    public Person(String name, int age) {
        this.name = name;
        this.age = age;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    @Override
    public String toString() {
        return "Person{" +
                "name='" + name + '\'' +
                ", age=" + age +
                '}';
    }
}
