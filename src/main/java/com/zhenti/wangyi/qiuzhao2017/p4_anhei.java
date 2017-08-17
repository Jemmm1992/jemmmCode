package com.zhenti.wangyi.qiuzhao2017;

import java.util.Scanner;

/**
 * Created by BIG-JIAN on 2017/8/12.
 */
public class p4_anhei {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        while (sc.hasNextInt()) {
            int n = sc.nextInt();
            long total = (long) Math.pow(3, n);
            if (n < 3) {
                System.out.println(total);
            } else {
                long t2 = (long) Math.pow(3, n - 3);
                System.out.println(total - t2 * 6 * (n - 2));
            }
        }
    }
}
