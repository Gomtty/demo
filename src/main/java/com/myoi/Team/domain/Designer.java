package com.myoi.Team.domain;

import com.myoi.Team.service.Status;

/**
 * @author myoi
 * @date 2021/12/10 - 9:28
 */
public class Designer extends Programmer {

    private double bonus;

    public Designer() {
    }

    public Designer(int id, String name, double salary, int age, Equirment equirment, double bonus) {
        super(id, name, salary, age, equirment);
        this.bonus = bonus;
    }

    public double getBonus() {
        return bonus;
    }

    public void setBonus(double bonus) {
        this.bonus = bonus;
    }

    @Override
    public String toString() {
        return getDetails() + "\t\t设计师\t\t" + getStatus() + "\t\t" + bonus + "\t\t\t\t\t" + getEquirment().getDescription();
    }

    public String getDetailForTeam() {
        return getMemberId() + "/" + getId() + "\t\t\t" + getName() + "\t" + getAge() + "\t\t\t" + getSalary() + "\t\t设计师\t\t" + getBonus();
    }
}
