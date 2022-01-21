package com.myoi.Team.test;

import com.myoi.Team.domain.Employee;
import com.myoi.Team.service.NameListService;
import com.myoi.Team.service.TeamException;
import org.junit.Test;

/**
 * @author myoi
 * @date 2021/12/10 - 10:41
 */
public class TeamTest {

    NameListService ns=new NameListService();

    @Test
    public void test1() {
        for (int i = 0; i < ns.getAllEmployees().length; i++) {
            System.out.println(ns.getAllEmployees()[i]);
        }
    }
    @Test
    public void testGet() {
        try {
            Employee employee = ns.getEmployee(20);
            System.out.println(employee);
        } catch (TeamException e) {
            e.printStackTrace();
        }

    }
}
