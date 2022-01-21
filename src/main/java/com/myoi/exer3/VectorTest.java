package com.myoi.exer3;

import java.util.Scanner;
import java.util.Vector;

/**
 * @author myoi
 * @date 2021/12/7 - 10:45
 */
public class VectorTest {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Vector v = new Vector();
        int max=0;
        while (true) {
            int nextInt = scanner.nextInt();
            if ( nextInt== -1) {
                break;
            }
            if (nextInt > 100) {
                continue;
            }
            v.addElement(nextInt);
            if (nextInt > max) {
                max=nextInt;
            }
        }

        for (int i = 0; i < v.size(); i++) {
            int score = (Integer) v.elementAt(i);
            if (max - score <= 10) {
                System.out.println("A");
            }else if (max - score <= 20) {
                System.out.println("B");
            }else if (max - score <= 30) {
                System.out.println("C");
            }else{
                System.out.println("D");
            }

        }
    }
}
