package com.leetcode.other;

import java.util.Arrays;

/**
 * Created by BIG-JIAN on 2017/7/25.
 * 这道题跟3Sum很类似，区别就是要维护一个最小的diff，求出和目标最近的三个和。brute force时间复杂度为O(n^3)，
 * 优化的解法是使用排序之后夹逼的方法，总的时间复杂度为O(n^2+nlogn)=(n^2),空间复杂度是O(n).
 */
public class P5_3SumCloest {
    public int threeSumClosest(int[] num, int target) {
        if (num == null || num.length <= 2)
            return Integer.MIN_VALUE;
        Arrays.sort(num);
        int closest = num[0] + num[1] + num[2] - target;
        for (int i = 0; i < num.length - 2; i++) {
            int cur = twoSum(num, target - num[i], i + 1);
            if (Math.abs(cur) < Math.abs(closest))
                closest = cur;
        }
        return target + closest;
    }

    private int twoSum(int[] num, int target, int start) {
        int closest = num[start] + num[start + 1] - target;
        int l = start;
        int r = num.length - 1;
        while (l < r) {
            if (num[l] + num[r] == target)
                return 0;
            int diff = num[l] + num[r] - target;
            if (Math.abs(diff) < Math.abs(closest))
                closest = diff;
            if (num[l] + num[r] > target) {
                r--;
            } else {
                l++;
            }
        }
        return closest;
    }
}
