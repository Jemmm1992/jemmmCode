package com.zhenti.CodeM;

import java.util.Scanner;

/**
 * Created by BIG-JIAN on 2017/7/30.
 */
public class tes2 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int len1 = sc.nextInt();
        int[] a = new int[len1];
        for (int i = 0; i < len1; i++) {
            a[i] = sc.nextInt();
        }
        int len2 = sc.nextInt();
        int[] b = new int[len2];
        for (int i = 0; i < len2; i++) {
            b[i] = sc.nextInt();
        }
        int[] dp = new int[len2 - len1 + 1];
        for (int i = 0; i < len2 - len1+1; i++) {
            for (int j = 0; j < len1; j++) {
                dp[i] += Math.pow(b[j+i] - a[j], 2);
            }
        }
        int min = Integer.MAX_VALUE;
        for (int i = 0; i < dp.length; i++) {
            min = Math.min(min, dp[i]);
        }
        System.out.println(min);
    }
}
