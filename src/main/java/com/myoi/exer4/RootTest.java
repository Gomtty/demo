package com.myoi.exer4;

/**
 * @author myoi
 * @date 2021/12/8 - 9:21
 */
public class RootTest {
    public static void main(String[] args) {
        new Leaf();
    }
}

class Root{
    static{
        System.out.println("Root静态代码块");
    }
    {
        System.out.println("Root非静态代码块");
    }

    public Root() {
        super();
        System.out.println("Root构造器");
    }
}
class Mid extends Root{
    static{
        System.out.println("Mid:静态代码块");
    }
    {
        System.out.println("Mid:非静态代码块");
    }

    public Mid() {
        super();
        System.out.println("Mid:构造器");
    }
}
class Leaf extends Mid{
    static{
        System.out.println("Leaf:静态代码块");
    }
    {
        System.out.println("Leaf:非静态代码块");
    }

    public Leaf() {
        super();
        System.out.println("Leaf:构造器");
    }

}