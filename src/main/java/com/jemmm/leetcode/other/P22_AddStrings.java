package com.jemmm.leetcode.other;

/**
 * Created by xu_zj on 2017/7/28.
 */
public class P22_AddStrings {
    public static void main(String[] args) {
        String s1 = "111";
        String s2 = "989";
        System.out.println(addStrings(s1, s2));
    }

    public static String addStrings(String num1, String num2) {
        int i = num1.length() - 1, j = num2.length() - 1, carry = 0;
        String res = "";
        while (i >= 0 || j >= 0) {
            if (i >= 0) carry += num1.charAt(i--) - '0';
            if (j >= 0) carry += num2.charAt(j--) - '0';
            res = Integer.toString(carry % 10) + res;
            carry /= 10;
        }
        return carry != 0 ? "1" + res : res;
    }
}
