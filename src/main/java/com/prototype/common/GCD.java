package com.prototype.common;

/**
 * Created by BIG-JIAN on 2017/8/20.
 * 求两个数的最大公约数
 */
public class GCD {
    /**
     * 原理： m / n = q ; m % n = r;
     * 则m和n的最大公约数等于 n和r的最大公约数。证明略
     * 当r等于0的时候则说明m为最大公约数
     */
    public static int gcd(int m, int n) {
        return n == 0 ? m : gcd(n, m % n);
    }

    public static void main(String[] args) {
        System.out.println(gcd(27, 18));
    }
}
