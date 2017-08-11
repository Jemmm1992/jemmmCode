package com.zhenti.wangyi;

import java.util.Scanner;

/**
 * Created by BIG-JIAN on 2017/8/9.
 */
public class p9_tuqipan {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        char[][] c = new char[n][n];
        for (int i = 0; i < n; i++) {
            c[i] = sc.next().toCharArray();
        }
        int max = 0;
        for (int i = 0; i < n; i++) {
            int tmp = 1;
            for (int j = 1; j < n; j++) {
                if (c[j - 1][i] == c[j][i]) {
                    tmp++;
                } else {
                    tmp = 1;
                }
                max = max > tmp ? max : tmp;
            }
        }
        System.out.println(max);
    }
}
