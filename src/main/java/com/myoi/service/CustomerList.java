package com.myoi.service;

import com.myoi.bean.Customer;

import java.util.Arrays;

/**
 * @author myoi
 * @date 2021/12/5 - 9:39
 */
public class CustomerList {
    private Customer[] customers;
    private int total;

    public CustomerList(int initCM) {
        this.customers = new Customer[initCM];
    }

    public boolean add(Customer customer) {
        if (total >= customers.length) {
            return false;
        }
        customers[total++]=customer;
        return true;
    }

    public boolean update(int index,Customer customer) {
        if (index < 0 || index >= total) {
            return false;
        }
        customers[index]=customer;
        return true;
    }
    
    /**
    * @Description:
    * @Param: [int]
    * @return: boolean
    * @Author: myoi
    * @Date: 2021/12/5 - 15:54
    */
    public boolean delete(int index) {
        if (index < 0 || index >= total) {
            return false;
        }
        for (int i = index; i < total-1; i++) {
            customers[i]=customers[i+1];
        }
        customers[--total]=null;
        return true;
    }

    
    public Customer[] getCustomers() {
        return Arrays.copyOf(customers, total);
    }

    public Customer getCustomer(int index) {
        if (index < 0 || index >= total) {
            return null;
        }
        return customers[index];
    }

    public int getTotal() {
        return total;
    }

}
