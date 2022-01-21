package com.myoi.Team.service;

import com.myoi.Team.domain.Architect;
import com.myoi.Team.domain.Designer;
import com.myoi.Team.domain.Employee;
import com.myoi.Team.domain.Programmer;

/**
 * @author myoi
 * @date 2021/12/9 - 15:21
 */
public class TeamService {

    private static int counter = 1;//为新添加的员工自动赋上id
    private final int MAX_MEMBER = 5;//团队里最多人数
    private Programmer[] team = new Programmer[MAX_MEMBER];
    private int total;//记录team中实际的人数


    public Programmer[] getTeam() {
        Programmer[] teamMember = new Programmer[total];
        System.arraycopy(team, 0, teamMember, 0, total);
        return teamMember;
    }

    public void addMember(Employee e) throws TeamException {
        if (total >= MAX_MEMBER) {
            throw new TeamException("成员已满，无法添加");
        }
        if (!(e instanceof Programmer)) {
            throw new TeamException("不是程序员，不能加");
        }
        if (isExist(e)) {
            throw new TeamException("已经是团队成员，无法重复添加");
        }
        Programmer p=(Programmer) e;
        if ("BUSY".equals(p.getStatus())) {
            throw new TeamException("员工在忙");
        }
        if ("VOCATION".equals(p.getStatus())) {
            throw new TeamException("员工在休假");
        }
        int numOfArc=0,numOfDes=0,numOfPro=0;
        for (int i = 0; i < total; i++) {
            if (team[i] instanceof Architect) {
                numOfArc++;
            } else if (team[i] instanceof Designer) {
                numOfDes++;
            } else {
                numOfPro++;
            }
        }
        if (p instanceof Architect) {
            if (numOfArc >= 1) {
                throw new TeamException("已经有一位架构师了");
            }
        } else if (p instanceof Designer) {
            if (numOfDes >= 2) {
                throw new TeamException("已经有两位设计师了");
            }
        }else {
            if (numOfPro >= 3) {
                throw new TeamException("已经有3位程序员了");
            }
        }

        team[total++]=p;
        p.setStatus(Status.BUSY);
        p.setMemberId(counter++);


    }

    public void removeMember(int memberId) throws TeamException {
        boolean flag=false;
        for (int i = 0; i < total; i++) {
            if (team[i].getMemberId() == memberId) {
                flag=true;
                team[i].setStatus(Status.FREE);
                for (int j = i; j < total-1; j++) {
                    team[j]=team[j+1];
                }
                team[--total]=null;
            }
        }
        if (!flag) {
            throw new TeamException("找不到指定memberID的员工");
        }
    }

    private boolean isExist(Employee e) {
        for (int i = 0; i < total; i++) {
            if (team[i].getId() == e.getId()) {
                return true;
            }
        }
        return false;
    }

}
