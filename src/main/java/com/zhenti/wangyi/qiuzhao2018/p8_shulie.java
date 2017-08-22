package com.zhenti.wangyi.qiuzhao2018;

import java.util.Scanner;

/**
 * Created by BIG-JIAN on 2017/8/12.
 */
public class p8_shulie {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int k = sc.nextInt();
        bfs(n, k, 0, 1);
        System.out.println(cnt);
    }

    static int cnt = 0;
    public static void bfs(int n, int k, int pre, int le) {
        if (le == n + 1) {
            cnt++;
            return;
        }
        if (le == 1) {
            for (int i = 1; i <= k; i++) {
                bfs(n, k, i, le + 1);
            }
        }else {
            for (int i = 1; i <= k; i++) {
                if (pre > i && pre % i == 0) continue;
                bfs(n, k, i, le + 1);
            }
        }
    }
}
