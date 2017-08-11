package com.zhenti.pinduoduo;

import java.util.Scanner;

/**
 * Created by BIG-JIAN on 2017/8/5.
 */
public class Main_1 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        long[] a = new long[n];
        for (int i = 0; i < n; i++) {
            a[i] = sc.nextLong();
        }
        long a1 = Long.MIN_VALUE, a2 = Long.MIN_VALUE, a3 = Long.MIN_VALUE, a4 = Long.MAX_VALUE, a5 = Long.MAX_VALUE;
        for (int i = 0; i < n; i++) {
            if (a[i] >= a1) {
                a3 = a2;
                a2 = a1;
                a1 = a[i];
            } else if (a[i] >= a2) {
                a3 = a2;
                a2 = a[i];
            } else if (a[i] >= a3) {
                a3 = a[i];
            }
            if (a[i] <= a4) {
                a5 = a4;
                a4 = a[i];
            } else if (a[i] <= a5) {
                a5 = a[i];
            }
        }
        long s1 = a1 * a2 * a3;
        long s2 = a1 * a4 * a5;
        System.out.println(Math.max(s1, s2));
    }

}
