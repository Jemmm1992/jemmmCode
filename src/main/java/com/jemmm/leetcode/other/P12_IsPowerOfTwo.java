package com.jemmm.leetcode.other;

/**
 * Created by BIG-JIAN on 2017/7/27.
 */
public class P12_IsPowerOfTwo {
    public boolean isPowerOfTwo(int n) {
        if (n < 0) return false;
        boolean hasOne = false;
        while (n > 0) {
            if ((n & 1) == 1) {
                if (hasOne) {
                    return false;
                } else {
                    hasOne = true;
                }
            }
            n >>= 1;
        }
        return hasOne;
    }
}
