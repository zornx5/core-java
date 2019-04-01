/*
 * Copyright (c) 2019. Zorn(zornx5@gmail.com). All rights reserved.
 */

package cn.zornx5.learn.corejava.v1ch04.employee;

import java.time.LocalDate;

/**
 * EmployeeDemo 类.
 *
 * @author Zorn
 * @version 1.0
 * @date 2019/3/29
 */
public class EmployeeDemo {
    public static void main(String[] args) {
        // 使用对象填充数组 staff
        Employee[] staff = new Employee[3];

        staff[0] = new Employee("Carl Cracker", 75000, 1987, 12, 15);
        staff[1] = new Employee("Harry Hacker", 50000, 1989, 10, 1);
        staff[2] = new Employee("Tony Tester", 40000, 1990, 3, 15);

        // 涨薪水 5%
        for (Employee e : staff) {
            e.raiseSalary(5);
        }

        // 打印对象信息
        for (Employee e : staff) {
            System.out.println("name=" + e.getName() + ",salary=" + e.getSalary() + ",hireDay="
                    + e.getHireDay());
        }
    }
}

class Employee {
    /**
     * 姓名
     */
    private String name;
    /**
     * 薪水
     */
    private double salary;
    /**
     * 雇佣时间
     */
    private LocalDate hireDay;

    /**
     * 初始化对象成员
     */
    public Employee(String n, double s, int year, int month, int day) {
        name = n;
        salary = s;
        hireDay = LocalDate.of(year, month, day);

    }

    public String getName() {
        return name;
    }

    public double getSalary() {
        return salary;
    }

    public LocalDate getHireDay() {
        return hireDay;
    }

    /**
     * 涨薪水
     */
    public void raiseSalary(double byPercent) {
        double raise = salary * byPercent / 100;
        salary += raise;
    }
}
