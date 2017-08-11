package com.zhenti.wangyi;
/**
 * http://blog.csdn.net/zhufenghao/article/details/69802667
 */

import java.util.Scanner;

public class p11_duizhuankuai {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        while (sc.hasNext()) {
            int n = sc.nextInt();
            int[] h = new int[n];
            int sum = 0;
            for (int i = 0; i < n; i++) {
                h[i] = sc.nextInt();
                sum += h[i];
            }
            int[][] dp = new int[2][sum + 1]; //dp[i][j]表示前i个砖块中，堆成的塔，高度差为j时，低塔的最高高度
            for (int i = 0; i < 2; i++) {
                for (int j = 0; j < sum + 1; j++) {
                    dp[i][j] = Integer.MIN_VALUE;
                    //初始化为负无穷，表示没有这种高度的堆法
                }
            }
            dp[0][0] = 0; //如果没有放砖的时候，低塔为0，高度差为0
            for (int i = 1; i <= n; i++) {
                int high = h[i - 1];
                for (int j = 0; j <= sum; j++) {
                    if (j > high) {
                        //如果将砖块放在高塔上，则低塔高度不变，高度差增加
                        dp[1][j] = Math.max(dp[1][j], dp[0][j - high]);
                    } else {
                        //如果将砖块放在低塔上，低塔变高塔，高塔高度变低塔高度，高度差改变
                        dp[1][j] = Math.max(dp[1][j], dp[0][high - j] + (high - j));
                    }
                    //如果将新砖块放在低塔上，并且依然是低塔，则低塔高度增加
                    if (j + high <= sum) dp[1][j] = Math.max(dp[1][j], dp[0][j + high] + high);
                    //放弃该砖块，不放在任何一个塔上
                    dp[1][j] = Math.max(dp[1][j], dp[0][j]);
                }
                System.arraycopy(dp[1], 0, dp[0], 0, sum + 1);
                for (int j = 0; j <= sum; j++) {
                    dp[1][0] = Integer.MIN_VALUE;
                }
            }
            if (dp[0][0] > 0) System.out.println(dp[0][0]);
            else System.out.println(-1);
        }
    }
}