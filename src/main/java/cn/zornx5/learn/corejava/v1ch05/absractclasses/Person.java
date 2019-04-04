/*
 * Copyright (c) 2019. Zorn(zornx5@gmail.com). All rights reserved.
 */

package cn.zornx5.learn.corejava.v1ch05.absractclasses;

/**
 * Person 类.
 * 抽象 人 .
 *
 * @author Zorn
 * @version 1.0
 * @date 2019/4/1
 */
public abstract class Person {
    private String name;

    public Person(String name) {
        this.name = name;
    }

    public abstract String getDescription();

    public String getName() {
        return name;
    }
}
