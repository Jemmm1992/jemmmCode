package com.jemmm.leetcode.other;

/**
 * Created by BIG-JIAN on 2017/7/28.
 */
public class P24_ReverseInteger {
    public static void main(String[] args) {
        System.out.println(reverse(-2147483648));
        System.out.println((int) -2147483648);
        System.out.println(Integer.MAX_VALUE);
    }

    public static int reverse(int x) {
        int result = 0, tail, newResult;
        while (x != 0) {
            tail = x % 10;
            newResult = result * 10 + tail;
            if ((newResult - tail) / 10 != result) return 0;
            result = newResult;
            x = x / 10;
        }
        return result;
    }

}
