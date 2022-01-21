package com.myoi.uitl;

import java.util.Scanner;

/**
 * @author myoi
 * @date 2021/12/5 - 9:43
 */
public class CMutil {

    private static Scanner scanner = new Scanner(System.in);

    public static char readMenu() {
        char c;
        while (true) {
            c = ReadKey(1, false).charAt(0);
            if (c == '1' || c == '2' || c == '3' || c == '4' || c == '5') {
                break;
            }else System.out.println("输入有误，请重新输入");
        }
        return  c;
    }

    public static char readChar() {
        String s = ReadKey(1, false);
        return s.charAt(0);
    }

    public static char readChar(char defaultChar) {
        String s = ReadKey(1, true);
        return "".equals(s) ? defaultChar : s.charAt(0);
    }

    public static int readInt() {
        int n;
        while (true) {
            String s = ReadKey(2, false);
            try {
                n=Integer.parseInt(s);
                break;
            } catch (Exception e) {
                System.out.println("输入有误，请输入不超过两位的数字");
            }
        }
        return n;

    }

    public static int readInt(int defaultInt) {
        int n;
        while (true) {
            String s = ReadKey(2, true);
            if ("".equals(s)) {
                return defaultInt;
            }
            try {
                n = Integer.parseInt(s);
                break;
            } catch (NumberFormatException e) {
                System.out.println("输入有误，请输入不超过两位的数字");
            }
        }
        return n;
    }

    public static String readString(int limit) {
        return ReadKey(limit, false);
    }

    public static String readString(int limit, String defaultString) {
        String s = ReadKey(limit, true);
        return s.equals("") ? defaultString : s;
    }


    public static char readConfirm() {
        char c;
        while (true) {
            String s = ReadKey(1, false).toUpperCase();
            c = s.charAt(0);
            if (c == 'Y' || c == 'N') {
                break;
            } else {
                System.out.println("输入有误，请重新输入");
            }
        }
        return c;
    }

    //读取键盘输入
    private static String ReadKey(int limit,boolean blankReturn) {
        String line = "";
        while (scanner.hasNextLine()) {
            line=scanner.nextLine();
            if (line.length() == 0) {
                if (blankReturn) {
                    return line;
                }else continue;
            }
            if (line.length() > limit) {
                System.out.println("输入长度应不大于"+limit+"，请重新输入");
                continue;
            }
            break;
        }
        return line;
    }


}
