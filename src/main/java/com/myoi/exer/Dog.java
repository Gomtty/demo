package com.myoi.exer;

/**
 * @author myoi
 * @date 2021/12/9 - 9:41
 */
public abstract class Dog {

    public static String name = "花花";

    public abstract void eat();

}

interface Walk{
    void run();
}



class DogTest{

    public static void main(String[] args) {

        Dog dog=new Dog(){
            @Override
            public void eat() {
                System.out.println("狗吃饭");
            }
        };
        dog.eat();

        Walk walk=new Walk(){
            @Override
            public void run() {
                System.out.println("run");
            }
        };
        walk.run();

    }
}