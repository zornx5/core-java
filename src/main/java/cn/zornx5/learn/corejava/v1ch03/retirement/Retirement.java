/*
 * Copyright (c) 2019. Zorn(zornx5@gmail.com). All rights reserved.
 */

package cn.zornx5.learn.core.java.v1ch03.retirement;


import java.util.Scanner;

/**
 * retirement 类.
 * 存退休金计算，while 循环 demo.
 *
 * @author Zorn
 * @version 1.0
 * @date 2019/3/28
 */
public class Retirement {
    public static void main(String[] args) {
        // 读取输入
        Scanner in = new Scanner(System.in);

        System.out.print("How much money do you need to retire? ");
        double goal = in.nextDouble();

        System.out.print("How much money will you contribute every year? ");
        double payment = in.nextDouble();

        System.out.print("Interest rate in %: ");
        double interestRate = in.nextDouble();

        double balance = 0;
        int years = 0;

        System.out.println("= = = while demo = = =");
        whileTest(goal, payment, interestRate, balance, years);
        System.out.println("= = = do while demo = = =");
        doWhileTest(in, goal, payment, interestRate, balance, years);

    }

    private static void whileTest(double goal, double payment, double interestRate, double balance, int years) {
        // 没有达到目标前循环更新账户额度
        while (balance < goal) {
            // 增加存款和利息
            balance += payment;
            double interest = balance * interestRate / 100;
            balance += interest;
            years++;
        }
        // 输出退休年数
        System.out.println("You can retire in " + years + " years.");
    }

    private static void doWhileTest(Scanner in, double goal, double payment, double interestRate, double balance, int years) {
        String input;

        // 没有准备退休则更新余额
        do {
            // 增加存款和利息
            balance += payment;
            double interest = balance * interestRate / 100;
            balance += interest;

            years++;

            // 当前余额
            System.out.printf("After year %d, your balance is %,.2f%n", years, balance);

            if (balance > goal) {
                System.out.println("You can retire in " + years + " years.");
                break;
            }

            // 人机交互
            System.out.print("Ready to retire? (Y/N) ");
            input = in.next();
        }
        while ("N".equals(input));
    }
}
