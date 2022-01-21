package com.myoi.exer2;

/**
 * @author myoi
 * @date 2021/12/6 - 14:07
 */
public class Sub extends Base{
    int count = 20;

    @Override
    public void display() {
        System.out.println(this.count);
    }

    public static void main(String[] args) {
        Account account1 = new Account(1001, 100, 1);
        Account account2 = new Account(1001, 100, 1);
        System.out.println(account1.equals(account2));
    }
}
