package com.myoi.exer2;

import java.util.Objects;

/**
 * @author myoi
 * @date 2021/12/6 - 10:38
 */
public class Account {
    private int id;//账号
    private double balance;//余额
    private double AIR;//年利率

    public Account(int id, double balance, double AIR) {
        this.id = id;
        this.balance = balance;
        this.AIR = AIR;
    }

    public double getMonthAIR() {
        return AIR/12;
    }

    public boolean withdraw(double amount) {
        if (balance >= amount) {
            balance-=amount;
            return true;
        }
        System.out.println("余额不足");
        return false;
    }

    public void deposit(double amount) {
        if (amount > 0) {
            balance += amount;
            return;
        }
        System.out.println("数值错误");
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public double getBalance() {
        return balance;
    }

    public void setBalance(double balance) {
        this.balance = balance;
    }

    public double getAIR() {
        return AIR;
    }

    public void setAIR(double AIR) {
        this.AIR = AIR;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o instanceof Account) {
            Account account = (Account) o;
            return this.id == account.id && this.balance == account.balance && this.AIR == account.AIR;
        }
        return false;
    }


    @Override
    public String toString() {
        return "Account{" +
                "id=" + id +
                ", balance=" + balance +
                ", AIR=" + AIR +
                '}';
    }
}
