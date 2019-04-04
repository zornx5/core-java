/*
 * Copyright (c) 2019. Zorn(zornx5@gmail.com). All rights reserved.
 */

package cn.zornx5.learn.corejava.v1ch05.equals;

/**
 * Manager 类.
 *
 * @author Zorn
 * @version 1.0
 * @date 2019/4/1
 */
public class Manager extends Employee {
    private double bonus;

    public Manager(String name, double salary, int year, int month, int day) {
        super(name, salary, year, month, day);
        bonus = 0;
    }

    @Override
    public double getSalary() {
        double baseSalary = super.getSalary();
        return baseSalary + bonus;
    }

    public void setBonus(double bonus) {
        this.bonus = bonus;
    }

    /**
     * equals 方法重载.
     *
     * @param otherObject 比较对象
     * @return boolean
     */
    @Override
    public boolean equals(Object otherObject) {
        // 调用超类先行对比
        if (!super.equals(otherObject)) {
            return false;
        }
        Manager other = (Manager) otherObject;
        // super.equals checked that this and other belong to the same class
        return bonus == other.bonus;
    }

    @Override
    public int hashCode() {
        // 调用超类先行返回，然后加子类 hashcode
        return java.util.Objects.hash(super.hashCode(), bonus);
    }

    @Override
    public String toString() {
        // 调用超类先行输出，在调用子类输出
        return super.toString() + "[bonus=" + bonus + "]";
    }
}

