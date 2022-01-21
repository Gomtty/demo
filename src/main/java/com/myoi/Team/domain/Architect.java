package com.myoi.Team.domain;

import com.myoi.Team.service.Status;

/**
 * @author myoi
 * @date 2021/12/10 - 9:29
 */
public class Architect extends Designer {

    private int stock;

    public Architect() {
    }

    public Architect(int id, String name, double salary, int age, Equirment equirment, double bonus, int stock) {
        super(id, name, salary, age, equirment, bonus);
        this.stock = stock;
    }

    @Override
    public String toString() {
        return getDetails() + "\t\t架构师\t\t" + getStatus() + "\t\t" + getBonus() + "\t\t" + stock + "\t\t" + getEquirment().getDescription();
    }

    public String getDetailForTeam() {
        return getMemberId() + "/" + getId() + "\t\t\t" + getName() + "\t" + getAge() + "\t\t\t" + getSalary() + "\t\t架构师\t\t" + getBonus() + "\t\t" + stock;
    }
}
