package com.leetcode.dp;

import static com.jemmm.utils.PrintfUtils.printf;

/**
 * Created by BIG-JIAN on 2017/7/30.
 * 最长递增子序列
 */
public class A_LongestSubSeq {
    public static void main(String[] args) {
        int[] a = {2, 1, 5, 3, 6, 4, 8, 9, 7};
        int[] dp = getdp1(a);
        printf(dp);
        printf(generateLis(a, dp));
    }

    /**
     * o(n2)
     */
    public static int[] getdp1(int[] a) {
        int[] dp = new int[a.length];
        for (int i = 0; i < a.length; i++) {
            dp[i] = 1;
            for (int j = 0; j < i; j++) {
                if (a[i] > a[j])
                    dp[i] = Math.max(dp[i], dp[j] + 1);
            }
        }
        return dp;
    }

    public static int[] generateLis(int[] a, int[] dp) {
        int index = 0;
        int len = 0;
        //获取dp中的最大值
        for (int i = 0; i < dp.length; i++) {
            if (dp[i] > len) {
                len = dp[i];
                index = i;
            }
        }
        int[] lis = new int[len];
        lis[--len] = a[index];
        for (int i = index; i >= 0; i--) {
            if (a[i] < a[index] && dp[i] == dp[index] - 1) {
                lis[--len] = a[i];
                index = i;
            }
        }
        return lis;
    }


}
