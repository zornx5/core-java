/*
 * Copyright (c) 2019. Zorn(zornx5@gmail.com). All rights reserved.
 */

package cn.zornx5.learn.corejava.v1ch04.paramtest;

/**
 * ParamTest 类.
 * 了解参数.
 *
 * @author Zorn
 * @version 1.0
 * @date 2019/4/1
 */
public class ParamTest {
    public static void main(String[] args) {
        /*
         * Test 1: 方法没有修改参数
         */
        System.out.println("Testing tripleValue:");
        double percent = 10;
        System.out.println("Before: percent=" + percent);
        tripleValue(percent);
        System.out.println("After: percent=" + percent);

        /*
         * Test 2: 方法可以改变对象参数的状态
         */
        System.out.println("\nTesting tripleSalary:");
        Employee harry = new Employee("Harry", 50000);
        System.out.println("Before: salary=" + harry.getSalary());
        tripleSalary(harry);
        System.out.println("After: salary=" + harry.getSalary());

        /*
         * Test 3: 方法无法将新对象附加到对象参数
         */
        System.out.println("\nTesting swap:");
        Employee a = new Employee("Alice", 70000);
        Employee b = new Employee("Bob", 60000);
        System.out.println("Before: a=" + a.getName());
        System.out.println("Before: b=" + b.getName());
        swap(a, b);
        System.out.println("After: a=" + a.getName());
        System.out.println("After: b=" + b.getName());
    }

    /**
     * 三倍数，形参变换，实参未变化.
     *
     * @param x 浮点数
     */
    public static void tripleValue(double x) {
        x = 3 * x;
        System.out.println("End of method: x=" + x);
    }

    /**
     * 三倍薪水，对象状态变化.
     *
     * @param x 雇员
     */
    public static void tripleSalary(Employee x) {
        x.raiseSalary(200);
        System.out.println("End of method: salary=" + x.getSalary());
    }

    /**
     * 失败的交换对象，形参变化，但是实参没有变化.
     *
     * @param x 雇员1
     * @param y 雇员2
     */
    public static void swap(Employee x, Employee y) {
        Employee temp = x;
        x = y;
        y = temp;
        System.out.println("End of method: x=" + x.getName());
        System.out.println("End of method: y=" + y.getName());
    }
}

/**
 * Employee 类.
 * 简单的对象类.
 *
 * @author Zorn
 * @version 1.0
 * @date 2019/4/1
 */
class Employee {
    private String name;
    private double salary;

    public Employee(String n, double s) {
        name = n;
        salary = s;
    }

    public String getName() {
        return name;
    }

    public double getSalary() {
        return salary;
    }

    public void raiseSalary(double byPercent) {
        double raise = salary * byPercent / 100;
        salary += raise;
    }
}
