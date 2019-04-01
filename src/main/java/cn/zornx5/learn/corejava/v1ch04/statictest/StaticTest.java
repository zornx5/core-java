/*
 * Copyright (c) 2019. Zorn(zornx5@gmail.com). All rights reserved.
 */

package cn.zornx5.learn.corejava.v1ch04.statictest;

/**
 * StaticTest 类.
 * 了解静态方法，静态变量.
 *
 * @author Zorn
 * @version 1.0
 * @date 2019/4/1
 */
public class StaticTest {
    public static void main(String[] args) {
        // 使用对象填充数组 staff
        Employee[] staff = new Employee[3];

        staff[0] = new Employee("Tom", 40000);
        staff[1] = new Employee("Dick", 60000);
        staff[2] = new Employee("Harry", 65000);

        // 打印对象信息
        for (Employee e : staff) {
            e.setId();
            System.out.println("name=" + e.getName() + ",id=" + e.getId() + ",salary="
                    + e.getSalary());
        }

        // 调用静态方法
        int n = Employee.getNextId();
        System.out.println("Next available id=" + n);
    }
}

class Employee {
    private static int nextId = 1;

    private String name;
    private double salary;
    private int id;

    public Employee(String n, double s) {
        name = n;
        salary = s;
        id = 0;
    }

    public static int getNextId() {
        // 返回静态变量
        return nextId;
    }

    /**
     * 单元测试
     */
    public static void main(String[] args) {
        Employee e = new Employee("Harry", 50000);
        System.out.println(e.getName() + " " + e.getSalary());
    }

    public String getName() {
        return name;
    }

    public double getSalary() {
        return salary;
    }

    public int getId() {
        return id;
    }

    public void setId() {
        // 将id设置为下一个可用id
        id = nextId;
        nextId++;
    }
}
