package com.myoi.Team.service;

import com.myoi.Team.domain.*;

/**
 * @author myoi
 * @date 2021/12/9 - 15:21
 */
public class NameListService {

    private Employee[] employees;

    public NameListService() {
        employees=new Employee[Data.EMPLYOEES.length];
        for (int i = 0; i < employees.length; i++) {
            int type=Integer.parseInt(Data.EMPLYOEES[i][0]);
            int id=Integer.parseInt(Data.EMPLYOEES[i][1]);
            String name=Data.EMPLYOEES[i][2];
            int age=Integer.parseInt(Data.EMPLYOEES[i][3]);
            double salary=Double.parseDouble(Data.EMPLYOEES[i][4]);
            Equirment equirment;
            double bonus;
            int stock;
            switch (type) {
                case Data.EMPLOYEE:
                    employees[i]=new Employee(id,name,salary,age);
                    break;
                case Data.PROGRAMMER:
                    equirment=getEquirmentById(i);
                    employees[i]=new Programmer(id,name,salary,age,equirment);
                    break;
                case Data.DESIGNER:
                    equirment=getEquirmentById(i);
                    bonus=Double.parseDouble(Data.EMPLYOEES[i][5]);
                    employees[i]=new Designer(id,name,salary,age,equirment,bonus);
                    break;
                case Data.ARCHITECT:
                    equirment=getEquirmentById(i);
                    bonus=Double.parseDouble(Data.EMPLYOEES[i][5]);
                    stock=Integer.parseInt(Data.EMPLYOEES[i][6]);
                    employees[i]=new Architect(id,name,salary,age,equirment,bonus,stock);
                    break;

            }


        }
    }

    public Employee[] getAllEmployees() {
        return employees;
    }

    public Employee getEmployee(int id) throws TeamException{
        for (Employee employee : employees) {
            if (id == employee.getId()) {
                return employee;
            }
        }
        throw new TeamException("没有找到该id对应的员工");
    }

    private Equirment getEquirmentById(int i) {
        int Etype=Integer.parseInt(Data.EQUIRMENTS[i][0]);
        String name = Data.EQUIRMENTS[i][1];
        String display = Data.EQUIRMENTS[i][2];
        switch (Etype) {
            case Data.PC:
                return new PC(name,display);
            case Data.NOTEBOOK:
                double price = Double.parseDouble(display);
                return new NoteBook(name,price);
            case Data.PRINTER:
                return new Printer(name,display);
        }
        return null;
    }


}
