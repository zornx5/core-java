/*
 * Copyright (c) 2019. Zorn(zornx5@gmail.com). All rights reserved.
 */

package cn.zornx5.learn.corejava.v1ch05.equals;

import java.time.LocalDate;
import java.util.Objects;

/**
 * Employee 类.
 * 重写 equals hashcode String 方法.
 *
 * @author Zorn
 * @version 1.0
 * @date 2019/4/1
 */
public class Employee {
    private String name;
    private double salary;
    private LocalDate hireDay;

    public Employee(String name, double salary, int year, int month, int day) {
        this.name = name;
        this.salary = salary;
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

    public void raiseSalary(double byPercent) {
        double raise = salary * byPercent / 100;
        salary += raise;
    }

    /**
     * 重写 equals 方法.
     *
     * @param otherObject 其他比较对象
     * @return boolean
     */
    @Override
    public boolean equals(Object otherObject) {
        // 快速测试对象是否相同
        if (this == otherObject) {
            return true;
        }
        // 传入对象为空直接返回 false
        if (otherObject == null) {
            return false;
        }
        // 类不同也返回 false
        if (getClass() != otherObject.getClass()) {
            return false;
        }
        // 其他对象非空，转换为本类对象
        Employee other = (Employee) otherObject;

        // 对比域参数是否相等
        return Objects.equals(name, other.name) && salary == other.salary && Objects.equals(hireDay, other.hireDay);
    }

    /**
     * 重写 hashcode 方法.
     */
    @Override
    public int hashCode() {
        return Objects.hash(name, salary, hireDay);
    }

    /**
     * 重写 toString 方法.
     */
    @Override
    public String toString() {
        return getClass().getName() + "[name=" + name + ",salary=" + salary + ",hireDay=" + hireDay
                + "]";
    }
}
