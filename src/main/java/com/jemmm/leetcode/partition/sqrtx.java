package com.jemmm.leetcode.partition;

/**
 * Created by BIG-JIAN on 2017/6/18.
 */

/**
 * Implementint sqrt(int x).
 * Compute and return the square root of x.
 */
public class sqrtx {
    public static void main(String[] args) {
        int i = 2;
        System.out.println(sqrt(i));
    }

    public static  int sqrt(int n) {

        if (n == 0) return 0;
        if (n == 1) return 1;
        int begin = 0, end = n / 2 +1;  // 考虑int n = 2的case，+1.
        while (begin < end - 1) {
            int mid = (begin + end) / 2;
            if (mid > n / mid) {
                end = mid;
            } else if (mid < n / mid) {
                begin = mid;
            } else {
                return mid;
            }
        }
        return begin;
    }
}
