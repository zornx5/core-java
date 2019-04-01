/*
 * Copyright (c) 2019. Zorn(zornx5@gmail.com). All rights reserved.
 */

package cn.zornx5.learn.corejava.v1ch04.clalendar;

import java.time.DayOfWeek;
import java.time.LocalDate;

/**
 * CalendarDemo 类.
 * 理解对象，打印日历.
 * 调用接口无需关心内部实现.
 *
 * @author Zorn
 * @date 2019/3/29
 */
public class CalendarDemo {
    public static void main(String[] args) {
        // 建立日历对象并且使用当前时间初始化
        LocalDate date = LocalDate.now();
        int month = date.getMonthValue();
        int today = date.getDayOfMonth();

        // 设置 date 为这个月第一天
        date = date.minusDays(today - 1);

        // 获取这一天为星期几
        DayOfWeek weekday = date.getDayOfWeek();

        // 周一为1 周末为7
        int value = weekday.getValue();

        System.out.println("Mon Tue Wed Thu Fri Sat Sun");
        for (int i = 1; i < value; i++) {
            System.out.print("    ");
        }
        while (date.getMonthValue() == month) {
            System.out.printf("%3d", date.getDayOfMonth());
            if (date.getDayOfMonth() == today) {
                System.out.print("*");
            } else {
                System.out.print(" ");
            }
            date = date.plusDays(1);
            if (date.getDayOfWeek().getValue() == 1) {
                System.out.println();
            }
        }
        if (date.getDayOfWeek().getValue() != 1) {
            System.out.println();
        }
    }
}
