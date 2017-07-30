package com.jemmm.leetcode.dp;

/**
 * Created by BIG-JIAN on 2017/7/29.
 */
public class P9_ClimbStairs {
    public static void main(String[] args) {
        System.out.println(climbStairs(5));
    }


    public static int climbStairs2(int n) {
        if (n <= 2) return n;
        int dp1 = 1, dp2 = 2;
        for (int i = 2; i < n; i++) {
            int tmp = dp1;
            dp1 = dp2;
            dp2 = tmp + dp2;
        }
        return dp2;
    }

    public static int climbStairs(int n) {
        if (n <= 2) return n;
        int[] dp = new int[n];
        dp[0] = 1;
        dp[1] = 2;
        for (int i = 2; i < n; i++) {
            dp[i] = dp[i - 2] + dp[i - 1];
        }
        return dp[n - 1];
    }
}
