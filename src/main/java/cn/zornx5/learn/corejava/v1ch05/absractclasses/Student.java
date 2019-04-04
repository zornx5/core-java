/*
 * Copyright (c) 2019. Zorn(zornx5@gmail.com). All rights reserved.
 */

package cn.zornx5.learn.corejava.v1ch05.absractclasses;

/**
 * Student 类.
 * 继承抽象 人.
 *
 * @author Zorn
 * @version 1.0
 * @date 2019/4/1
 */
public class Student extends Person {
    private String major;

    /**
     * @param name  学生名
     * @param major 学生专业
     */
    public Student(String name, String major) {
        // name 给超类构造
        super(name);
        this.major = major;
    }

    @Override
    public String getDescription() {
        return "a student majoring in " + major;
    }
}
