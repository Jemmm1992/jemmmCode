package com.zhenti.pinduoduo;

import java.util.Arrays;
import java.util.Scanner;

/**
 * Created by BIG-JIAN on 2017/8/1.
 */
public class Main4 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] a = new int[n];
        for (int i = 0; i < n; i++) {
            a[i] = sc.nextInt();
        }
        if (a == null || a.length < 3) {
            System.out.println(0);
        }
        if (a.length == 3) {
            System.out.println(a[0] * a[1] * a[2]);
        } else {
            Arrays.sort(a);
            int a1 = a[0] * a[1] * a[a.length - 1];
            int a2 = a[a.length - 1] * a[a.length - 2] * a[a.length - 3];
            if (a1 > a2) {
                System.out.println(a1);
            } else {
                System.out.println(a2);
            }
        }
    }
}
