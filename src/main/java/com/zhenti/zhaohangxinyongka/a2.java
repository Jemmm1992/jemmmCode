package com.zhenti.zhaohangxinyongka;

import java.util.Scanner;

/**
 * Created by BIG-JIAN on 2017/9/13.
 */
public class a2 {
     // 偷鸡的方法
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] a = new int[n];
        for (int i = 0; i < n; i++) {
            a[i] = sc.nextInt();
        }

        if (n <= 2) {
            System.out.println("true");
        } else if (n > 2 && n <= 4) {
            int s1 = a[0] + a[1];
            int s2 = 0;
            for (int i = 2; i < n; i++) {
                s2 += a[i];
            }
            if (s1 > s2) System.out.println("true");
            else System.out.println("false");
        } else {
            if (n % 2 == 1) System.out.println("true");
            else System.out.println("false");
        }
    }
}
