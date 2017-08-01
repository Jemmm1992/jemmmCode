package com.prototype.common;

import static com.utils.PrintfUtils.printf;

/**
 * Created by BIG-JIAN on 2017/7/8.
 */
public class knapsack01 {
    public static void main(String[] args) {
        int[] w = { 3, 5, 1, 2, 2 };
        int[] c = { 4, 5, 2, 1, 3 };
        int total = 9;
        int[][] dp1 = get1(w, c, total);
        printf(dp1);
        int[] dp2 = get2(w, c, total);
        printf(dp2);
    }

    private static int[] get2(int[] w, int[] c, int total) {
        // 初始化
        int[] dp = new int[total + 1];
        for (int i = 0; i <= total; i++) {
            if (i >= w[0]) {
                dp[i] = c[0];
            }
        }
        for (int i = 1; i < w.length; i++) {
            for (int j = total; j >= 1; j--) {
                if (j >= w[i]) {
                    dp[j] = Math.max(dp[j - w[i]] + c[i], dp[j]);
                } else {
                    dp[j] = dp[j];
                }
            }
        }
        return dp;
    }

    private static int[][] get1(int[] w, int[] c, int total) {
		/*
		 * 初始化
		 */
        int[][] dp = new int[w.length][total + 1];
        for (int i = 0; i <= total; i++) {
            if (i >= w[0]) {
                dp[0][i] = c[0];
            }
        }
        for (int i = 1; i < w.length; i++) {
            for (int j = 1; j <= total; j++) {
                if (j >= w[i]) {
                    dp[i][j] = Math.max(dp[i - 1][j], dp[i - 1][j - w[i]] + c[i]);
                } else {
                    dp[i][j] = dp[i - 1][j];
                }
            }
        }
        return dp;

    }
}
