package com.zhenti.wangyi.qiuzhao2017;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 * Created by BIG-JIAN on 2017/8/12.
 */
public class p3_tiaoshiban {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int a = sc.nextInt();
        int b = sc.nextInt();
        System.out.println(get(a, b));
    }

    public static int get(int a, int b) {
        int[] dp = new int[b + 1];
        for (int i = a; i <= b; i++) {
            List<Integer> yue = getYue(i);
            for (Integer item : yue) {
                if (i + item <= b) {
                    if (dp[i + item] == 0) dp[i + item] = 1 + dp[i];
                    else dp[i + item] = Math.min(dp[i] + 1, dp[i + item]);
                }
            }
        }
        return dp[b] == 0 ? -1 : dp[b];

    }

    public static List<Integer> getYue(int n) {
        List<Integer> list = new ArrayList<>();
        for (int i = 2; i <= Math.sqrt(n); i++) {
            if (n % i == 0) {
                list.add(i);
                list.add(n / i);
            }
        }
        return list;
    }
}
