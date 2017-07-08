package com.jemmm.prototype;

import static com.jemmm.utils.PrintfUtils.printf;

/**
 * Created by BIG-JIAN on 2017/7/8.
 * 完全背包
 */
public class knapsackFull {
    public static void main(String[] args) {
        int[] wt = { 3, 4, 6, 2, 5 };
        int[] val = { 6, 8, 7, 5, 9 };
        int w = 10;
        int n = wt.length;
        int[][] dp = new int[n + 1][w + 1];
        for (int i = 1; i <= n; i++) {
            for (int v = 1; v <= w; v++) {
                if (v >= wt[i - 1]) {
                    dp[i][v] = Math.max(dp[i][v - wt[i - 1]] + val[i - 1], dp[i - 1][v]);
                } else {
                    dp[i][v] = dp[i - 1][v];
                }
            }
        }
        printf(dp);
    }
}
