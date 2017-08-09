package com.zhenti.wangyi;

import java.util.Scanner;

/**
 * Created by BIG-JIAN on 2017/8/9.
 * http://blog.csdn.net/wwe4023/article/details/70171648
 */
public class p12_fenpingan {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String s = sc.next();
        int n = sc.nextInt();
        System.out.println(combinationCount(s, n));
    }

    public static long combinationCount(String s, int n) {
        int len = s.length();
        long[][] dp = new long[len + 1][n];
        dp[0][0] = 1;

        for (int i = 1; i <= len; i++) {
            for (int j = 0; j < n; j++) {
                if (s.charAt(i - 1) == 'X') {
                    for (int k = 0; k <= 9; k++) {
                        int newJ = (j * 10 + k) % n;
                        dp[i][newJ] += dp[i - 1][j];
                    }
                } else {
                    int newJ = (j * 10 + (s.charAt(i - 1) - '0')) % n;
                    dp[i][newJ] += dp[i - 1][j];
                }
            }
        }
        return dp[len][0];
    }
}
