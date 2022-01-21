package com.myoi.exer;


/**
 * @author myoi
 * @date 2021/12/4 - 10:11
 */
public class day01 {
    public static void main(String[] args) {
        Animal animal = new Animal();
        animal.name="大黄";
//        animal.legs=-1;
        animal.setLegs(10);
        animal.age=10;
        animal.show();
    }

}

class Animal{
    String name;
    private int legs;
    int age;

    public void setLegs(int l) {
        if (l >= 0 && l < 10) {
            legs = l;
        } else {
            legs=0;
        }
    }

    public void show() {
        System.out.println("name="+name+";legs="+legs+";age="+age);
    }


}
