/*
 * Copyright (c) 2019. Zorn(zornx5@gmail.com). All rights reserved.
 */

package cn.zornx5.learn.corejava.v1ch04.constructor;

import java.util.Random;

/**
 * ConstructorTest 类.
 * 重载
 *
 * @author Zorn
 * @version 1.0
 * @date 2019/4/1
 */
public class ConstructorTest {
    public static void main(String[] args) {
        // 创建三个构造器
        Employee[] staff = new Employee[3];

        staff[0] = new Employee("Harry", 40000);
        staff[1] = new Employee(60000);
        staff[2] = new Employee();

        // 打印对象
        for (Employee e : staff) {
            System.out.println("name=" + e.getName() + ",id=" + e.getId() + ",salary=" + e.getSalary());
        }
    }
}

class Employee {
    private static int nextId;

    // 静态初始化代码块
    static {
        Random generator = new Random();
        // set nextId to a random number between 0 and 9999
        nextId = generator.nextInt(10000);
    }

    private int id;
    /**
     * 实例域初始化
     */
    private double salary;
    private String name = "";

    // 对象初始化代码块
    {
        id = nextId;
        nextId++;
    }

    /**
     * 重载构造器
     */
    public Employee(String n, double s) {
        name = n;
        salary = s;
    }

    /**
     * 重载构造器
     */
    public Employee(double s) {
        // 调用 Employee(String, double) constructor
        this("Employee #" + nextId, s);
    }

    /**
     * 默认构造器
     */
    public Employee() {
        // name initialized to ""--see above
        // salary not explicitly set--initialized to 0
        // id initialized in initialization block
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
}
