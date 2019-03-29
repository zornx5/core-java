/*
 * Copyright (c) 2019. Zorn(zornx5@gmail.com). All rights reserved.
 */

package cn.zornx5.learn.core.java.v1ch02;

/**
 * Welcome 类.
 * 入门程序.
 *
 * @author Zorn
 * @date 2019/3/27
 */
public class Welcome {
    public static void main(String[] args) {
        String greeting = "Welcome to Core Java!";
        System.out.println(greeting);
        for (int i = 0; i < greeting.length(); i++) {
            System.out.print("=");
        }
        System.out.println();
    }
}
