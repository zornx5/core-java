/*
 * Copyright (c) 2019. Zorn(zornx5@gmail.com). All rights reserved.
 */

package cn.zornx5.learn.corejava.v1ch03.lottery;

import java.math.BigInteger;
import java.util.Arrays;
import java.util.Scanner;

/**
 * Lottery 类.
 * 抽取，for 循环 demo，BigInteger demo，不规则数组.
 *
 * @author Zorn
 * @version 1.0
 * @date 2019/3/28
 */
public class Lottery {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);

        System.out.print("How many numbers do you need to draw? ");
        int num = in.nextInt();

        System.out.print("What is the highest number you can draw? ");
        int highest = in.nextInt();

        System.out.println("Your odds are 1 in " + odds(num, highest) + ". Good luck!");

        System.out.printf("If numbers * 10 = %d, highest number *10 = %d \n", num * 10, highest * 10);
        System.out.println("Your odds are 1 in " + bigInteger(num * 10, highest * 10) + ". Good luck!");

        drawing(num, highest);

        array();

    }

    /**
     * 计算中奖.
     *
     * @param num     抽取数
     * @param highest 最大数
     * @return int 可能数
     */
    private static int odds(int num, int highest) {
        /*
         * 二项式公式 n*(n-1)*(n-2)*...*(n-k+1)/(1*2*3*...*k)
         */
        int lotteryOdds = 1;
        for (int i = 1; i <= num; i++) {
            lotteryOdds = lotteryOdds * (highest - i + 1) / i;
        }
        return lotteryOdds;
    }

    /**
     * 计算中奖，大数值.
     *
     * @param num     抽取数
     * @param highest 最大数
     * @return BigInteger 可能数
     */
    private static BigInteger bigInteger(int num, int highest) {
        BigInteger lotteryOdds = BigInteger.valueOf(1);
        for (int i = 1; i <= num; i++) {
            lotteryOdds = lotteryOdds.multiply(BigInteger.valueOf(highest - i + 1)).divide(BigInteger.valueOf(i));
        }
        return lotteryOdds;
    }

    private static void drawing(int num, int highest) {
        // 0 - (highest-1) 填充数组
        int[] numbers = new int[highest];
        for (int i = 0; i < numbers.length; i++) {
            numbers[i] = i + 1;
        }

        // 用来存储结果
        int[] result = new int[num];
        for (int i = 0; i < result.length; i++) {
            // 生成随机整数 0 - (highest-1)
            int r = (int) (Math.random() * highest);

            // 存储选中
            result[i] = numbers[r];

            // 去重，此数移动至数组末尾
            numbers[r] = numbers[highest - 1];
            highest--;
        }

        // 排序
        Arrays.sort(result);
        System.out.println("Bet the following combination. It'll make you rich!");
        // for each 循环
        for (int r : result) {
            System.out.print(r + " | ");
        }
        System.out.println();
    }

    private static void array() {
        final int N_MAX = 10;

        // 二维数组
        int[][] odds = new int[N_MAX + 1][];
        for (int n = 0; n <= N_MAX; n++) {
            odds[n] = new int[n + 1];
        }

        // 填充数组
        for (int n = 0; n < odds.length; n++) {
            for (int k = 0; k < odds[n].length; k++) {
                odds[n][k] = odds(n, k);
            }
        }

        // 打印数组，for each 不能自动处理二维数组，需要嵌套
        for (int[] row : odds) {
            for (int odd : row) {
                System.out.printf("%4d", odd);
            }
            System.out.println();
        }
    }
}
