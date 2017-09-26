package com.zhenti.zhaohangxinyongka;

import java.util.Scanner;

/**
 * Created by BIG-JIAN on 2017/9/11.
 * 求a和b小于n的公倍数
 */
public class a1 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int a = sc.nextInt();
        int b = sc.nextInt();
        int n = sc.nextInt();
        int res = multiple(a, b);
        int cnt = 1;
        if (res > n) {
            System.out.println(0);
        } else {
            while (cnt * res <= n) {
                 cnt++;
            }
            System.out.println(cnt-1);
        }
    }

    public static int multiple(int x, int y) {
        int z;
        for (z = x; ; z++) {
            if (z % x == 0 && z % y == 0) {
                break;
            }
        }
        return z;
    }
}
