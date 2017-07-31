package com.jemmm.leetcode.other;

/**
 * Created by xu_zj on 2017/7/28.
 */
public class P21_AddBinary_ {
    public String addBinary(String a, String b) {
        int i = a.length() - 1, j = b.length() - 1, carry = 0;
        String res = "";
        while (i >= 0 || j >= 0) {
            if (i >= 0) carry += a.charAt(i--) - '0';
            if (j >= 0) carry += b.charAt(j--) - '0';
            res = Integer.toString(carry % 2) + res;
            carry /= 2;
        }
        return carry != 0 ? "1" + res : res;
    }
}
