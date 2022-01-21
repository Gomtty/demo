package com.myoi.Thread;

/**
 * @author myoi
 * @date 2021/12/11 - 16:28
 */
public class pvTest {
    public static void main(String[] args) {
        Clerk clerk = new Clerk();
        Productor productor = new Productor(clerk);
        Consumer consumer = new Consumer(clerk);
        Thread pThread = new Thread(productor);
        Thread cThread = new Thread(consumer);
        pThread.setName("生产者进程");
        cThread.setName("消费者进程");
        pThread.start();
        cThread.start();
    }
}

class Clerk{
    public static int product;
    public static final int MAX_PRODUCT=5;


}

class Productor implements Runnable{
    private Clerk clerk;

    public Productor(Clerk clerk) {
        this.clerk = clerk;
    }

    @Override
    public void run() {

        System.out.println(Thread.currentThread().getName()+":开始生产产品");
        while (true) {
            synchronized (clerk) {
                if (Clerk.product < Clerk.MAX_PRODUCT) {
                    try {
                        Thread.sleep(100);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                    Clerk.product++;
                    System.out.println("生产第：" + Clerk.product + "个产品");
                    clerk.notify();
                } else {
                    try {
                        clerk.wait();
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            }
        }

    }


}
class Consumer implements Runnable{
    private Clerk clerk;

    public Consumer(Clerk clerk) {
        this.clerk = clerk;
    }

    @Override
    public void run() {

        System.out.println(Thread.currentThread().getName()+":开始消费产品");
        while (true) {
            synchronized (clerk) {
                if (Clerk.product > 0) {
                    System.out.println("消费第：" + Clerk.product + "个产品");
                    Clerk.product--;
                    clerk.notify();
                } else {
                    try {
                        clerk.wait();
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            }
        }
    }

}
