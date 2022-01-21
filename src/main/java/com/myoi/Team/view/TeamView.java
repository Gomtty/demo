package com.myoi.Team.view;

import com.myoi.Team.domain.Employee;
import com.myoi.Team.domain.Programmer;
import com.myoi.Team.service.NameListService;
import com.myoi.Team.service.TeamException;
import com.myoi.Team.service.TeamService;

/**
 * @author myoi
 * @date 2021/12/9 - 15:20
 */
public class TeamView {
    private NameListService ns=new NameListService();
    private TeamService ts=new TeamService();

    public void enterMenu() {
        boolean flag=true;
        char menu =0;

        while (flag) {
            if (menu != '1') {
                list();
                System.out.println("------------------------------------------------------------------------------------------------------");
            }
            System.out.print("1-团队列表，2-添加团队成员，3-删除团队成员，4-退出 (请选择1-4)：");
            menu = TsUtil.readMenu();
            switch (menu) {
                case '1':
                    getTeam();
                    break;
                case '2':
                    addMember();
                    break;
                case '3':
                    deleteMember();
                    break;
                case '4':
                    System.out.print("确定要退出吗? (Y/N)：");
                    char confirm = TsUtil.readConfirm();
                    if (confirm == 'Y') {
                        flag=false;
                    }
                    break;
            }
        }
    }

    private void list() {
        System.out.println("--------------------------------------------开发团队调度软件--------------------------------------------\n");
        System.out.println("ID\t\t姓名\t年龄\t\t工资\t\t职位\t\t状态\t\t奖金\t\t股票\t\t领用设备");
        Employee[] emps = ns.getAllEmployees();
        for (Employee emp : emps) {
            System.out.println(emp);
        }
    }

    private void getTeam() {
//        System.out.println("团队列表");
        System.out.println();
        System.out.println("--------------------------------------------团队成员列表展示--------------------------------------------");
        if (ts.getTeam() == null || ts.getTeam().length == 0) {
            System.out.println("该团队目前没有成员！");
        } else {
            System.out.println("TID/ID\t\t姓名\t年龄\t\t工资\t\t职位\t\t奖金\t\t股票");
            for (Programmer programmer : ts.getTeam()) {
                System.out.println(programmer.getDetailForTeam());
            }
        }
        System.out.println("------------------------------------------------------------------------------------------------------");
        System.out.println();
    }

    private void addMember()  {
//        System.out.println("添加团队成员");
        System.out.println();
        System.out.print("请输入员工的id：");
        int i = TsUtil.readInt();
        try {
            Employee employee = ns.getEmployee(i);
            ts.addMember(employee);
        } catch (TeamException e) {
            System.out.println(e.getMessage());
        }
        System.out.println("添加成功");
        TsUtil.readReturn();
    }
    private void deleteMember() {
//        System.out.println("删除团队成员");
        System.out.println();
        System.out.print("请输入删除员工的id：");
        int i = TsUtil.readInt();
        System.out.print("是否删除 (Y/N):");
        char c = TsUtil.readConfirm();
        if (c == 'N') {
            return;
        }
        try {
            ts.removeMember(i);
            System.out.println("删除成功");
        } catch (TeamException e) {
            System.out.println(e.getMessage());
        }
        TsUtil.readReturn();
    }

    public static void main(String[] args) {
        TeamView teamView = new TeamView();
        teamView.enterMenu();

    }

}
