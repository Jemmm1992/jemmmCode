package com.leetcode.dp;

/**
 * Created by BIG-JIAN on 2017/7/28.
 */
public class P2_MaxProfit {
    public int maxProfit(int[] prices) {
        if (prices.length < 2) return 0;
        int cur = prices[0], sum = 0;
        for (int i = 1; i < prices.length; i++) {
            if (prices[i] - prices[i - 1] > 0) {
                sum += prices[i] - prices[i - 1];
            }
        }
        return sum;
    }
}
