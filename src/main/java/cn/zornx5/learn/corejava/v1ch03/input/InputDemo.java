/*
 * Copyright (c) 2019. Zorn(zornx5@gmail.com). All rights reserved.
 */

package cn.zornx5.learn.core.java.v1ch03.input;

import java.util.Scanner;

/**
 * InputDemo 类.
 * 输入demo.
 *
 * @author Zorn
 * @version 1.0
 * @date 2019/3/28
 */
public class InputDemo {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);

        // 获取一行
        System.out.print("What is your name? ");
        String name = in.nextLine();

        // 获取一个 int
        System.out.print("How old are you? ");
        int age = in.nextInt();

        // 显示在命令行
        System.out.println("Hello, " + name + ". Next year, you'll be " + (age + 1));
    }
}
