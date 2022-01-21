package com.myoi.exer5;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * @author myoi
 * @date 2021/12/10 - 16:08
 */
public class ThreadTest {

    public static void main(String[] args) {


    }
}


class Bank{
    private static Bank bank=null;

    private Bank(){}

    public static Bank getInstance() {
        if (bank == null) {
            synchronized (Bank.class) {
                if (bank == null) {
                    bank=new Bank();
                }
            }
        }
        return bank;
    }
}

class Mythread1 implements Runnable{

    @Override
    public void run() {
        for (int i = 0; i < 100; i++) {
            if (i % 2 == 0) {
                System.out.println(Thread.currentThread().getName()+":"+i);
            }
        }
    }
}

class MyThread extends Thread {
    private static int ticket=100;

    @Override
    public void run() {
        while (true) {
            show();
        }
    }

    private synchronized void show() {
        if (ticket > 0) {
            try {
                sleep(50);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println("买到票了，票号为："+ticket);
            ticket--;
        }
    }
}


