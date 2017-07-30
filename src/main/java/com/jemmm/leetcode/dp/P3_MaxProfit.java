package com.jemmm.leetcode.dp;

import static com.jemmm.utils.PrintfUtils.printf;

/**
 * Created by BIG-JIAN on 2017/7/28.
 */
public class P3_MaxProfit {
    public static void main(String[] args) {
        int[] a = {1, 3, 2, 9};
        maxProfit(a);
    }

    public static int maxProfit(int[] prices) {
        return maxProfit(prices, 2);
    }

    /**
     * http://www.cnblogs.com/grandyang/p/4281975.html
     * global[i][j]：当前到达第i天可以最多进行j次交易，最好的利润
     * local[i][j]：当前到达第i天，最多可进行j次交易，并且最后一次交易在当天卖出的最好的利润是多少
     * global[i][j]=max(local[i][j],global[i-1][j])，
     * local[i][j]=max(global[i-1][j-1]+max(diff,0),local[i-1][j]+diff)，
     */
    public static int maxProfit(int[] prices, int k) {
        if (prices == null || prices.length == 0) return 0;
        int[][] local = new int[prices.length][k + 1];
        int[][] global = new int[prices.length][k + 1];
        for (int i = 1; i < prices.length; i++) {
            int diff = prices[i] - prices[i - 1];
            for (int j = 1; j <= k; ++j) {
                local[i][j] = Math.max(global[i - 1][j - 1] + (diff > 0 ? diff : 0), local[i - 1][j] + diff);
                global[i][j] = Math.max(local[i][j], global[i - 1][j]);
            }
        }
        printf(global);
        return global[prices.length - 1][k];
    }

    /**
     * 空间压缩法
     * 用一维数组来代替二维数组，可以极大的节省了空间，由于覆盖的顺序关系，我们需要j从2到1，这样可以取到正确的g[j-1]值，而非已经被覆盖过的值
     */
    public static int maxProfit2(int[] prices, int k) {
        if (prices == null || prices.length == 0) return 0;
        int[] g = new int[k + 1];
        int[] l = new int[k + 1];
        for (int i = 0; i < prices.length - 1; i++) {
            int diff = prices[i + 1] - prices[i];
            for (int j = k; j >= 1; --j) {
                l[j] = Math.max(g[j - 1] + Math.max(diff, 0), l[j] + diff);
                g[j] = Math.max(l[j], g[j]);
            }
        }
        return g[k];
    }

}
