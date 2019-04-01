/*
 * Copyright (c) 2019. Zorn(zornx5@gmail.com). All rights reserved.
 */

package cn.zornx5.learn.corejava.v1ch04.packagetest.horstmann;

import java.time.LocalDate;

/**
 * Employee 类.
 *
 * @author Zorn
 * @version 1.0
 * @date 2019/4/1
 */
public class Employee {
    static {
        // 静态代码块，对静态域进行初始化.
        System.out.println("Test object static code block.");
    }

    private String name;
    private double salary;
    private LocalDate hireDay;

    {
        //代码块，又称初始化代码块，只要构造类对象，这些块就会被执行.
        System.out.println("Test object code block.");
    }

    /**
     * 无参构造函数，用来初始化变量,如果没有自行编写此函数，那么系统会自动提供一个，会默认将所有实例域赋初值.
     */
    public Employee() {
        this.name = "";
        this.salary = 0;
        this.hireDay = LocalDate.now();
    }

    /**
     * this 调用另一个构造函数.
     */
    public Employee(String name) {
        this(name, 0, 2000, 1, 1);
    }


    public Employee(String name, double salary, int year, int month, int day) {
        this.name = name;
        this.salary = salary;
        hireDay = LocalDate.of(year, month, day);
    }

    public static void main(String[] args) {

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

    public void raiseSalary(double byPercent) {
        double raise = salary * byPercent / 100;
        salary += raise;
    }
}
