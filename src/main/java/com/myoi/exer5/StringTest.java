package com.myoi.exer5;

import org.junit.Test;

/**
 * @author myoi
 * @date 2021/12/12 - 10:54
 */
public class StringTest {

    @Test
    public void test3() {
        String str=null;
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append(str);
    }


    public String reverse1(String str, int startIndex, int endIndex) {
        if (str == null) {
            return null;
        }
        StringBuilder stringBuilder = new StringBuilder(str.length());
        stringBuilder.append(str, 0, startIndex);
        for (int i = endIndex; i >= startIndex; i--) {
            stringBuilder.append(str.charAt(i));
        }
        stringBuilder.append(str.substring(endIndex+1));

        return stringBuilder.toString();
    }

    public String reverse(String str, int startIndex, int endIndex) {
        if (str == null) {
            return null;
        }
        char[] chars = str.toCharArray();
        char temp;
        for (int i = startIndex, j = endIndex; i < j; i++, j--) {
            temp=chars[i];
            chars[i]=chars[j];
            chars[j]=temp;
        }
        return new String(chars);
    }

    @Test
    public void test2() {
        String str1 = "asdfqwewqerqwerqwsxkcnkqopewroipzmlkxcmwjewqrpwioutoperjekejsadieiwoaqppqrqw";
        String str2 = "viojkaixoijqwenaskldfjoiwwjoiejrqnxznvlklkajewqrpwioutopijxcnvbiqwwewwwerojdopqwerfeadfsafsdqwrqyura";
        String temp = str1;
        //最长字串
        String maxStr = "";
        for (int i = 0; i < str1.length(); i++) {
            for (int j = temp.length(); j > 0; j--) {
                String temp2 = temp.substring(0, j);
                if (str2.contains(temp2)) {

                    if (temp2.length() > maxStr.length()) {
                        maxStr = temp2;
                    }
                }
            }
            temp = temp.substring(1);
        }
        System.out.println("最大子串为：" + maxStr);

    }

    //去掉首尾多余的空格 //模拟 trim方法
    public String rs(String str) {
        String reg = "^\\s+|\\s+$";
        return str.replaceAll(reg, "");
    }

    @Test
    public void test1() {
        //字符串内 指定索引处 倒序
        String str = "abc123";//a21cb3
        //将字符串转换为 char[]数组
        char[] chars = str.toCharArray();
        //作为临时变量
        char temp;
        for (int i = 1, j = chars.length - 2; i < j; i++, j--) {
            temp = chars[i];
            chars[i] = chars[j];
            chars[j] = temp;
        }
        //将倒序后的char[]数组 重新转换为字符串
        String s = new String(chars);
        System.out.println(s);
    }

    public static void main(String[] args) {
        //待查找的字符串
        String str = "hellolowerlowqiajlo";
        //统计该字符串出现的次数
        String targetStr = "lo";
        //次数
        int count = 0;
        //初始为0，先从头开始找。找到目标字符串后，把当前索引 加上 本身字符串长度，继续从后面找
        int SearchIndex = 0;
        //找到 targetStr后返回的索引值 ，
        // 当targetStrIndex！=-1时，targetStrIndex加上 想要统计的字符串的长度 就是下次开始查找的索引值
        int targetStrIndex;
        // str.indexOf(targetStr, SearchIndex)表示 从SearchIndex开始 查找 目标字符串targetStr，找不到返回-1
        while ((targetStrIndex = str.indexOf(targetStr, SearchIndex)) != -1) {
            count++;
            SearchIndex = targetStrIndex + targetStr.length();
        }

        System.out.println(count);
    }
}
