package com.zhenti.wangyi.qiuzhao2018;

import java.util.Scanner;

/**
 * Created by BIG-JIAN on 2017/8/12.
 */
public class p5_dulidexiaoyi {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int x = sc.nextInt();
        int f = sc.nextInt();
        int d = sc.nextInt();
        int p = sc.nextInt();
        int cnt = 0;

        if (d < f * x) {
            System.out.println(d / x);
        } else if (d == f * x) {
            System.out.println(f);
        } else {
            d = d - f * x;
            cnt += f;
            while (d > 0) {
                d = d - x - p;
                if (d >= 0) cnt++;
            }
            System.out.println(cnt);
        }
    }
}
