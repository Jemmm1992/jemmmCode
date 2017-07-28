package com.jemmm.leetcode.other;

import static com.jemmm.utils.PrintfUtils.printf;

/**
 * Created by BIG-JIAN on 2017/7/27.
 */
public class p11_MissingNumber {
    public static void main(String[] args) {
        int[] a = {0, 1, 2, 3, 4, 6};
        int i = missingNumber(a);
        printf(i);
    }

    public static int missingNumber(int[] nums) {
        int x = 0;
        for (int i = 0; i <= nums.length; i++) x ^= i;
        for (Integer n : nums) x ^= n;
        return x;
    }
}
