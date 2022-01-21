package com.myoi.exer3;

/**
 * @author myoi
 * @date 2021/12/7 - 19:53
 */
public class SingletonTest {
    public static void main(String[] args) {
        Bank bank1 = Bank.getBank();
        Bank bank2 = Bank.getBank();
        System.out.println(bank1+""+bank2);
    }


}

class Bank{

    private static Bank bank =new Bank();
    private Bank() {
    }
    //饿汉式单例

    public static Bank getBank() {
        return bank;
    }
}
