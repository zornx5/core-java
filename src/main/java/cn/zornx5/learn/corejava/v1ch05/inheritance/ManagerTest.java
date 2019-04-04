/*
 * Copyright (c) 2019. Zorn(zornx5@gmail.com). All rights reserved.
 */

package cn.zornx5.learn.corejava.v1ch05.inheritance;

/**
 * ManagerTest 类.
 *
 * @author Zorn
 * @version 1.0
 * @date 2019/4/1
 */
public class ManagerTest {
    public static void main(String[] args) {
        // 构造管理对象
        Manager boss = new Manager("Carl Cracker", 80000, 1987, 12, 15);
        boss.setBonus(5000);

        Employee[] staff = new Employee[3];

        // 三个对象放入数组
        staff[0] = boss;
        staff[1] = new Employee("Harry Hacker", 50000, 1989, 10, 1);
        staff[2] = new Employee("Tommy Tester", 40000, 1990, 3, 15);

        // 打印对象信息，此处变量 e 可以指示管理者也可以是雇员，称为多态，在运行时选择调用哪个方法称之为动态绑定
        for (Employee e : staff) {
            System.out.println("name=" + e.getName() + ",salary=" + e.getSalary());
        }
    }
}