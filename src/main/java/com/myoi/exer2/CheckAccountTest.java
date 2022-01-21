package com.myoi.exer2;

/**
 * @author myoi
 * @date 2021/12/6 - 10:51
 */
public class CheckAccountTest {

    public static void main(String[] args) {
        CheckAccount checkAccount = new CheckAccount(1001, 20000, 0.045, 5000);
        checkAccount.withdraw(5000);
        System.out.println("余额："+checkAccount.getBalance());
        System.out.println("可透支额度："+checkAccount.getOverdraft());
        checkAccount.withdraw(18000);
        System.out.println("余额："+checkAccount.getBalance());
        System.out.println("可透支额度："+checkAccount.getOverdraft());
        checkAccount.withdraw(3000);
        System.out.println("余额："+checkAccount.getBalance());
        System.out.println("可透支额度："+checkAccount.getOverdraft());

    }
}
