/*
 * Copyright (c) 2019. Zorn(zornx5@gmail.com). All rights reserved.
 */

package cn.zornx5.learn.core.java.v1ch03.compound.interest;

/**
 * CompoundInterest 类.
 * 计算利息，二维数组使用.
 *
 * @author Zorn
 * @version 1.0
 * @date 2019/3/28
 */
public class CompoundInterest {
    public static void main(String[] args) {
        final double startRate = 10;
        final int nRates = 6;
        final int nYears = 10;

        // 投资利率 10 . . . 15%
        double[] interestRate = new double[nRates];
        for (int j = 0; j < interestRate.length; j++) {
            interestRate[j] = (startRate + j) / 100.0;
        }

        double[][] balances = new double[nYears][nRates];

        // 投资余额 10000
        for (int j = 0; j < balances[0].length; j++) {
            balances[0][j] = 10000;
        }

        // 计算未来利率
        for (int i = 1; i < balances.length; i++) {
            for (int j = 0; j < balances[i].length; j++) {
                // 获取前一年余额从上一行
                double oldBalance = balances[i - 1][j];

                // 计算利率
                double interest = oldBalance * interestRate[j];

                // 计算今年余额
                balances[i][j] = oldBalance + interest;
            }
        }

        // 打印一行利率
        for (int j = 0; j < interestRate.length; j++) {
            System.out.printf("%9.0f%%", 100 * interestRate[j]);
        }
        System.out.println();

        // 打印表格
        for (double[] row : balances) {
            // 打印一行
            for (double b : row) {
                System.out.printf("%10.2f", b);
            }
            System.out.println();
        }
    }
}
