package com.myoi.Team.view;

import java.util.Scanner;

/**
 * @author myoi
 * @date 2021/12/9 - 15:29
 */
public class TsUtil {
    private static Scanner scanner = new Scanner(System.in);

    /**
    * @Description: 等待用户输入一个 (1-5)中的数
    * @Param:       []
    * @ParamType:   []
    * @Return:      char
    * @Author:      myoi
    * @Date:        2021/12/9 - 16:04
    */
    public static char readMenu() {
        char c;
        while (true) {
            c = ReadKey(1, false).charAt(0);
            if (c == '1' || c == '2' || c == '3' || c == '4') {
                break;
            }else System.out.print("输入有误，请重新输入（1-4）中的数");
        }
        return c;
    }

    /**
    * @Description: 等待用户按回车键继续
    * @Param:       []
    * @ParamType:   []
    * @Return:      void
    * @Author:      myoi
    * @Date:        2021/12/9 - 16:01
    */
    public static void readReturn() {
        System.out.println("按回车键继续...");
        ReadKey(100, true);
    }

    /**
    * @Description: 读取一个不超过2位的整数
    * @Param:       []
    * @ParamType:   []
    * @Return:      int
    * @Author:      myoi
    * @Date:        2021/12/9 - 15:58
    */
    public static int readInt() {
        int n;
        while (true) {
            try {
                String s = ReadKey(2, false);
                n= Integer.parseInt(s);
                break;
            } catch (NumberFormatException e) {
                System.out.print("输入有误，请输入不超过2位的整数：");
            }
        }
        return n;
    }

    /**
    * @Description: 操作验证
    * @Param:       []
    * @ParamType:   []
    * @Return:      char
    * @Author:      myoi
    * @Date:        2021/12/9 - 15:54
    */
    public static char readConfirm() {
        char c;
        while (true) {
            c = ReadKey(1, false).toUpperCase().charAt(0);
            if (c == 'Y' || c == 'N') {
                break;
            } else {
                System.out.println("输入有误，请重新输入：");
            }
        }
        return c;
    }


    /**
    * @Description: 从键盘获取一个长度不超过limit的字符串
    * @Param:       [limit, blankReturn]
    * @ParamType:   [int, boolean]
    * @Return:      java.lang.String
    * @Author:      myoi
    * @Date:        2021/12/9 - 15:54
    */
    private static String ReadKey(int limit,boolean blankReturn) {
        String line = "";
        while (scanner.hasNextLine()) {
            line=scanner.nextLine();
            if (line.length() == 0) {
                if (blankReturn) {
                    return line;
                }
                else continue;
            }
            if (line.length() > limit) {
                System.out.println("输入应长度不超过"+limit+"，请重新输入");
                continue;
            }
            break;
        }
        return line;
    }
}
