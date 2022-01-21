package com.myoi.exer4;

/**
 * @author myoi
 * @date 2021/12/8 - 16:46
 */
public class CircleCompareble extends Circle implements CompareObject{

    public CircleCompareble() {
    }

    public CircleCompareble(double radius) {
        super(radius);
    }

    public static void main(String[] args) {
        CircleCompareble c1 = new CircleCompareble(3.14);
        CircleCompareble c2 = new CircleCompareble(3.14);
        c1.method1();
        System.out.println(c1.compareTo(c2));
    }

    public void method1() {
        CompareObject.super.getA();
        System.out.println("method1");
    }

    @Override
    public int compareTo(Object obj) {
        if (this == obj) {
            return 0;
        }
        if (obj instanceof CircleCompareble) {
            CircleCompareble c =(CircleCompareble) obj;
            if (this.getRadius() > c.getRadius()) {
                return 1;
            } else if (this.getRadius() < c.getRadius()) {
                return -1;
            } else {
                return 0;
            }
        }
        throw new RuntimeException("传入的数据类型不匹配");
    }
}
