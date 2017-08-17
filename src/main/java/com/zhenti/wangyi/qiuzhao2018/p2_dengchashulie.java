package com.zhenti.wangyi.qiuzhao2018;

import java.util.Arrays;
import java.util.Scanner;

/**
 * Created by BIG-JIAN on 2017/8/13.
 */
public class p2_dengchashulie {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] a = new int[n];
        for (int i = 0; i < n; i++) {
            a[i] = sc.nextInt();
        }
        Arrays.sort(a);
        int diff = a[0] - a[1];
        boolean b = false;
        for (int i = 1; i < a.length; i++) {
            if (a[i - 1] - a[i] != diff) {
                System.out.println("Impossible");
                b = true;
                break;
            }
        }
        if (!b) System.out.println("Possible");
    }
}
