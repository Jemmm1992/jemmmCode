package com.zhenti.wangyi.qiuzhao2018;

import java.util.Scanner;

/**
 * Created by BIG-JIAN on 2017/8/12.
 */
public class p8_shulie2 {
    static int n = 0;
    static int k = 0;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        n = sc.nextInt();
        k = sc.nextInt();
        bfs(0, 1);
        int mod = 1000000007;
        System.out.println(cnt % mod);
    }

    static int cnt = 0;

    public static void bfs(int pre, int le) {
        if (le == n + 1) {
            cnt++;
            return;
        }
        if (le == 1) {
            for (int i = 1; i <= k; i++) {
                bfs(i, le + 1);
            }
        } else {
            for (int i = 1; i <= k; i++) {
                if (pre > i && pre % i == 0) continue;
                bfs(i, le + 1);
            }
        }
    }
}
