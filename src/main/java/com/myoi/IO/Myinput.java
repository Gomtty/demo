package com.myoi.IO;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * @author myoi
 * @date 2021/12/17 - 10:11
 */
public class Myinput {
    private static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    public static String readString() {
        String str = "";
        try {
            str = br.readLine();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return str;
    }

    public static int readInt() {
        return Integer.parseInt(readString());
    }

    public static double readDouble() {
        return Double.parseDouble(readString());
    }

    public static void close() {
        try {
            if (br != null)
                br.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

}
