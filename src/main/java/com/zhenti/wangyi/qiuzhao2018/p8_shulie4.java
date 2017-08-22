package com.zhenti.wangyi.qiuzhao2018;

import java.util.Scanner;

/**
 * Created by BIG-JIAN on 2017/8/12.
 */
public class p8_shulie4 {
    public static void main(String[] args) {
        int mod = 1000000007;
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int k = sc.nextInt();
        int dp[][] = new int[n + 1][k + 1];
        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= k; j++) {
                if (i == 1) {
                    dp[i][j] = j;
                    continue;
                }
                for (int t = 1; t <= k; t++) {
                    if (t <= j || t % j != 0) {
                        dp[i][j] = (dp[i][j] + dp[i - 1][t]) % mod;
                    }
                }
            }
        }
        int res = dp[n][k];

        System.out.println(res);
    }
}