/*
 * Copyright (c) 2019. Zorn(zornx5@gmail.com). All rights reserved.
 */

package cn.zornx5.learn.corejava.v1ch05.inheritance;

/**
 * Manager 类.
 * 继承，重载.
 *
 * @author Zorn
 * @version 1.0
 * @date 2019/4/1
 */
public class Manager extends Employee {
    private double bonus;

    /**
     * @param name   雇员名
     * @param salary 薪水
     * @param year   聘请年份
     * @param month  聘请月份
     * @param day    聘请日
     */
    public Manager(String name, double salary, int year, int month, int day) {
        super(name, salary, year, month, day);
        bonus = 0;
    }

    /**
     * 重载结算薪水方法.
     */
    @Override
    public double getSalary() {
        double baseSalary = super.getSalary();
        return baseSalary + bonus;
    }

    /**
     * 新方法，设置奖金.
     *
     * @param b 金额
     */
    public void setBonus(double b) {
        bonus = b;
    }
}