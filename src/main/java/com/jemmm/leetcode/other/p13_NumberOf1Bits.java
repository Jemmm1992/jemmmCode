package com.jemmm.leetcode.other;

/**
 * Created by BIG-JIAN on 2017/7/27.
 */
public class p13_NumberOf1Bits {
    public static void main(String[] args) {
        int i = hammingWeight(11);
        int i2 = count2(11);
        System.out.println(i);
        System.out.println(i2);
    }

    public static int count2(int n) {
        int res = 0;
        while (n != 0) {
            n = n & (n - 1);
            res++;
        }
        return res;
    }

    public static int hammingWeight(int n) {
        int count = 0;
        while (n > 0) {
            count += n & 1;
            n >>= 1;
        }
        return count;
    }
}
