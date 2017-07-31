package com.leetcode.other;

/**
 * Created by xu_zj on 2017/7/28.
 */
public class P22_AddBinary {
    public static void main(String[] args) {
        String a = "11";
        String b = "10";
        System.out.println(addBinary(a, b));
    }

    public static String addBinary(String a, String b) {
        int i = a.length() - 1, j = b.length() - 1, carry = 0;
        StringBuffer sb = new StringBuffer();
        while (i >= 0 || j >= 0) {
            if (i >= 0) {
                carry += a.charAt(i--) - '0';
            }
            if (j >= 0) {
                carry += b.charAt(j--) - '0';
            }
            sb.append(carry % 2);
            carry /= 2;
        }
        if (carry == 1) sb.append(1);
        return sb.reverse().toString();
    }
}
