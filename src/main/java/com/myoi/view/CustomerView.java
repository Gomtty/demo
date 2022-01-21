package com.myoi.view;

import com.myoi.bean.Customer;
import com.myoi.service.CustomerList;
import com.myoi.uitl.CMutil;

/**
 * @author myoi
 * @date 2021/12/5 - 9:40
 */
public class CustomerView {

    private CustomerList customerList = new CustomerList(10);

    public CustomerView() {
        customerList.add(new Customer("张三",'男',18,"11223344556","123@qq.com"));
    }

    //显示主界面
    public void enterMenu() {
        boolean flag=true;
        while (flag) {
            System.out.println("---------------------menu--------------------");
            System.out.println("1 添加用户");
            System.out.println("2 修改用户");
            System.out.println("3 删除用户");
            System.out.println("4 用户列表");
            System.out.println("5 退出系统");
            System.out.println("       选择(1-5):");
            char c = CMutil.readMenu();
            switch (c) {
                case '1':
                    addCust();
                    break;
                case '2':
                    upCust();
                    break;
                case '3':
                    delCust();
                    break;
                case '4':
                    getCusts();
                    break;
                case '5':
                    System.out.println("是否退出系统,输入(y/n)");
                    if (CMutil.readConfirm() == 'Y') {
                        flag=false;
                        System.out.println("退出成功");
                    }
            }

        }
    }
    //添加客户

    public void addCust() {
        System.out.println("-添加用户-");
        System.out.println("请输入用户的姓名-不超过5位");
        String name = CMutil.readString(5);
        System.out.println("请输入用户的性别-男或女");
        char gender = CMutil.readChar();
        System.out.println("请输入用户的年龄-不超过两位");
        int age = CMutil.readInt();
        System.out.println("请输入用户的电话-不超过11位");
        String phone = CMutil.readString(11);
        System.out.println("请输入用户的邮箱");
        String email = CMutil.readString(20);
        if (customerList.add(new Customer(name, gender, age, phone, email))) {
            System.out.println("-----添加成功-------");
        }else System.out.println("-----添加失败-------");
    }
   //修改客户
    public void upCust() {
        System.out.println("-修改用户-");
        int i;
        while (true) {
            System.out.println("请输入修改用户的编号（-1退出）：");
             i= CMutil.readInt();
            if (i == -1) {
                return;
            }
            if (i <= 0 || i > customerList.getTotal()) {
                System.out.println("没有找到该用户！！");
            }else break;
        }
        Customer customer = customerList.getCustomer(i - 1);
        System.out.println("请输入用户的姓名("+customer.getName()+")-不超过5位");
        String name = CMutil.readString(5,customer.getName());
        System.out.println("请输入用户的性别"+customer.getGender()+"-男或女");
        char gender = CMutil.readChar(customer.getGender());
        System.out.println("请输入用户的年龄"+customer.getAge()+"-不超过两位");
        int age = CMutil.readInt(customer.getAge());
        System.out.println("请输入用户的电话"+customer.getPhone()+"-不超过11位");
        String phone = CMutil.readString(11,customer.getPhone());
        System.out.println("请输入用户的邮箱"+customer.getEmail());
        String email = CMutil.readString(20,customer.getEmail());
        customerList.update(i - 1, new Customer(name,gender,age,phone,email));
        System.out.println("修改客户成功");
    }
   //删除客户
    public void delCust() {
        System.out.println("-删除客户-");
        int i;
        while (true) {
            System.out.println("请输入删除用户的编号（-1退出）：");
            i= CMutil.readInt();
            if (i == -1) {
                return;
            }
            if (customerList.getCustomer(i-1)==null) {
                System.out.println("没有找到该用户！！");
            }else break;
        }
        if (customerList.delete(i - 1)) {
            System.out.println("删除成功");
        }else System.out.println("删除失败");

    }
   //查找客户
    
    public void getCusts() {
        System.out.println("编号\t姓名\t性别\t年龄\t电话\t邮箱\t");
        if (customerList.getTotal() == 0) {
            System.out.println("没有用户");
            return;
        }
        Customer[] customers = customerList.getCustomers();
        for (int i=0;i<customers.length;i++) {
            System.out.println(
                    i+1+"\t"+
                    customers[i].getName() + "\t" +
                    customers[i].getGender() + "\t" +
                    customers[i].getAge() + "\t" +
                    customers[i].getPhone() + "\t" +
                    customers[i].getEmail() + "\t"
            );
        }
    }

    public static void main(String[] args) {
        CustomerView customerView = new CustomerView();
        customerView.enterMenu();
    }

}
