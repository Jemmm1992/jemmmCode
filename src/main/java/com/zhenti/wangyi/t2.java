package com.zhenti.wangyi;

import java.util.Scanner;

/**
 * Created by BIG-JIAN on 2017/8/5.
 */
public class t2 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int d = sc.nextInt();
        int[][] a = new int[n][n];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                a[i][j] = sc.nextInt();
            }
        }
        int max = Integer.MIN_VALUE;
        for (int i = 0; i < n - d; i++) {
            for (int j = 0; j < n - d; j++) {
                max = Math.max(max, getMax(a, i, j, d));
            }
        }
        System.out.println(max);
    }

    public static int getMax(int[][] a, int x, int y, int d) {
        int max = Integer.MIN_VALUE;
        int tmp1 = 0, tmp2 = 0;

        for (int i = 0; i < d; i++) {
            tmp1 = 0;tmp2 = 0;
            for (int j = 0; j < d; j++) {
                tmp1 += a[x + i][y + j];
                tmp2 += a[x + j][y + i];
            }
            max = Math.max(max, tmp1);
            max = Math.max(max, tmp2);
        }

        tmp1 = 0;tmp2 = 0;
        for (int i = 0; i < d; i++) {
            tmp1 += a[x + i][y + i];
            tmp2 += a[x + i][y + d - 1 - i];
        }
        max = Math.max(max, tmp1);
        max = Math.max(max, tmp2);
        return max;
    }
}
//4 2
//87 98 79 61
//10 27 95 70
//20 64 73 29
//71 65 15 0