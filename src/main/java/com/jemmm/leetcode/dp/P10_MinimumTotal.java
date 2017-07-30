package com.jemmm.leetcode.dp;

import java.util.List;

/**
 * Created by BIG-JIAN on 2017/7/29.
 */
public class P10_MinimumTotal {

    /**
     * 自底向上
     * dp[m][n] = min(dp[m + 1][n], dp[m + 1][n + 1]) + triangle[m][n]
     * 因为要求o(n)，所以压缩空间，使用一维数组
     */
    public int minimumTotal(List<List<Integer>> list) {
        if (list == null || list.size() == 0) return 0;
        int m = list.size();
        int[] dp = new int[m];
        for (int i = 0; i < m; i++) {
            dp[i] = list.get(m - 1).get(i);
        }
        for (int i = m - 2; i >= 0; i--) {
            for (int j = 0; j <= i; j++) {
                dp[j] = list.get(i).get(j) + Math.min(dp[j], dp[j + 1]);
            }
        }
        return dp[0];
    }

    /**
     * 自顶向下
     * dp[m + 1][n] = min(dp[m][n], dp[m][n - 1]) + triangle[m + 1][n] if n > 0
     * dp[m + 1][0] = dp[m][0] + triangle[m + 1][0]
     */
    public int minimumTotal2(List<List<Integer>> list) {
        if (list == null || list.size() == 0) return 0;
        int row = list.size();
        int[] dp = new int[row];
        for (int i = 0; i < row; i++) {
            dp[i] = Integer.MAX_VALUE;
        }
        dp[0] = list.get(0).get(0);
        int minTotal = Integer.MAX_VALUE;
        for (int i = 1; i < row; i++) {
            for (int j = i; j >= 0; j--) {
                if (j == 0) {
                    dp[j] = dp[j] + list.get(i).get(j);
                } else {
                    dp[j] = Math.min(dp[j - 1], dp[j]) + list.get(i).get(j);
                }
            }
        }
        for (int i = 0; i < row; i++) {
            minTotal = Math.min(minTotal, dp[i]);
        }
        return minTotal;
    }


}
