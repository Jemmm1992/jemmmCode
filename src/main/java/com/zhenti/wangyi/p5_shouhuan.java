package com.zhenti.wangyi;

import java.util.Scanner;

/**
 * Created by BIG-JIAN on 2017/8/9.
 */
public class p5_shouhuan {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        long k = sc.nextLong();
        int[] a = new int[n];

        for (int i = 0; i < n; i++) {
            a[i] = sc.nextInt();
        }

        for(int i = 0 ; i <n; i ++){

        }
    }
}

//// 复杂度过大
//        for (int i = 0; i < k; i++) {
//        int tmp = a[0];
//        for (int j = 0; j < n; j++) {
//        if (j != n - 1) a[j] = (a[j] + a[j + 1]) % 100;
//        else a[j] = (a[j] + tmp) % 100;
//        }
//        }
//
//        for (int i = 0; i < n; i++) {
//        if (i == n - 1) System.out.print(a[i]);
//        else System.out.print(a[i] + " ");
//        }
