package com.myoi.exer2;

/**
 * @author myoi
 * @date 2021/12/6 - 10:38
 */
public class CheckAccount extends Account{

    private double overdraft;//可透支的额度

    public CheckAccount(int id, double balance, double AIR, double overdraft) {
        super(id,balance,AIR);
        this.overdraft=overdraft;
    }

    @Override
    public boolean withdraw(double amount) {
        if (super.withdraw(amount)) {
            return true;
        } else if (overdraft >= amount - getBalance()) {
            overdraft -= amount - getBalance();
            super.withdraw(getBalance());
            return true;
        }
        return false;
    }

    public double getOverdraft() {
        return overdraft;
    }
}
