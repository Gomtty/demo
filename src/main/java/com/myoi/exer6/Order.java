package com.myoi.exer6;

import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

/**
 * @author myoi
 * @date 2021/12/15 - 20:02
 */
public class Order<T> {
    private int id;
    private String name;
    private T orderT;

    public Order() {
    }

    public Order(int id, String name, T orderT) {
        this.id = id;
        this.name = name;
        this.orderT = orderT;
    }

    public T getOrderT() {
        return orderT;
    }

    public void setOrderT(T orderT) {
        this.orderT = orderT;
    }

    @Override
    public String toString() {
        return "Order{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", orderT=" + orderT +
                '}';
    }
}
class SubOrder<T> extends Order<T>{

    public <E> List<E> copyOfArr(E[] arr) {
        ArrayList<E> es = new ArrayList<>();
        for (E e : arr) {
            es.add(e);
        }
        return es;
    }

}

class OrderTest{
    public static void main(String[] args) {

    }
}
