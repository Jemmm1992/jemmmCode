package com.jemmm.leetcode.dp;

/**
 * Created by BIG-JIAN on 2017/7/29.
 */
public class P8_MaxProduct {
    public int maxProduct(int[] nums) {
        if (nums == null || nums.length == 0) return 0;
        if (nums.length == 1) return nums[0];
        int p = nums[0];
        int maxP = nums[0];
        int minP = nums[0];
        for (int i = 1; i < nums.length; i++) {
            int t = maxP;
            maxP = Math.max(Math.max(maxP * nums[i], nums[i]), minP * nums[i]);
            minP = Math.min(Math.min(t * nums[i], nums[i]), minP * nums[i]);
            p = Math.max(maxP, p);
        }
        return p;
    }
}
