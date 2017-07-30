package com.jemmm.leetcode.dp;

/**
 * Created by BIG-JIAN on 2017/7/28.
 */
public class P1_MaxProfit {
    public static void main(String[] args) {
        int[] a = {7, 1, 5, 3, 6, 4};
        int[] b = {7, 6, 4, 3, 1};
        System.out.println(maxProfit2(a));
    }

    public int maxProfit(int[] prices) {
        if (prices.length < 2) return 0;
        int minP = prices[0];
        int max = prices[1] - prices[0];
        for (int i = 2; i < prices.length; i++) {
            minP = Math.min(minP, prices[i - 1]);
            max = Math.max(max, prices[i] - minP);
        }
        if (max < 0) return 0;
        return max;
    }

    // dp ****
    public static int maxProfit2(int[] prices) {
        if (prices == null || prices.length == 0)
            return 0;
        int local = 0;
        int global = 0;
        for (int i = 0; i < prices.length - 1; i++) {
            local = Math.max(local + prices[i + 1] - prices[i], 0);
            System.out.println("local: " + local);
            global = Math.max(local, global);
            System.out.println("global: " + global);
        }
        return global;
    }
}
