/*
 * Copyright (c) 2019. Zorn(zornx5@gmail.com). All rights reserved.
 */

package cn.zornx5.learn.corejava.v1ch04.packagetest;


// 导入其他包

import cn.zornx5.learn.corejava.v1ch04.packagetest.horstmann.Employee;

import static java.lang.System.out;

// 静态导入

/**
 * This program demonstrates the use of packages.
 *
 * @author Cay Horstmann
 * @version 1.11 2004-02-19
 */
public class PackageTest {
    public static void main(String[] args) {
        Employee harry = new Employee("Harry Hacker", 50000, 1989, 10, 1);

        harry.raiseSalary(5);

        // 静态导入可以使用 System 的静态方法和域
        out.println("name=" + harry.getName() + ",salary=" + harry.getSalary());
    }
}
