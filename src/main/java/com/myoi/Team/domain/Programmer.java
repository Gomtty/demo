package com.myoi.Team.domain;

import com.myoi.Team.service.Status;

/**
 * @author myoi
 * @date 2021/12/10 - 9:11
 */
public class Programmer extends Employee{
    private int memberId;
    private Status status=Status.FREE;
    private Equirment equirment;

    public Programmer() {
    }

    public Programmer(int id, String name, double salary, int age, Equirment equirment) {
        super(id, name, salary, age);
        this.equirment = equirment;
    }

    public int getMemberId() {
        return memberId;
    }

    public void setMemberId(int memberId) {
        this.memberId = memberId;
    }

    public Status getStatus() {
        return status;
    }

    public void setStatus(Status status) {
        this.status = status;
    }

    public Equirment getEquirment() {
        return equirment;
    }

    public void setEquirment(Equirment equirment) {
        this.equirment = equirment;
    }

    @Override
    public String toString() {
        return getDetails() + "\t\t程序员\t\t" +status+"\t\t"+"\t\t\t\t\t\t"+equirment.getDescription();
    }

    public String getDetailForTeam() {
        return memberId + "/" + getId() + "\t\t\t" + getName() + "\t" + getAge() + "\t\t\t" + getSalary() + "\t\t程序员";
    }
}
