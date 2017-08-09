package com.zhenti.wangyi;

import java.util.Scanner;

/**
 * Created by BIG-JIAN on 2017/8/8.
 */
public class p3_adjustQ {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        char[] c1 = sc.next().toCharArray();
        int s1 = 0, s2 = 0;
        char[] c2 = new char[c1.length];
        System.arraycopy(c1,0,c2,0,c1.length);
        for (int i = 0; i < c1.length; i++) {
            for (int j = i - 1; j >= 0 && c1[j + 1] < c1[j]; j--) {
                swap(c1, j, j + 1);
                s1++;
            }
        }

        for (int i = 0; i < c2.length; i++) {
            for (int j = i - 1; j >= 0 && c2[j + 1] > c2[j]; j--) {
                swap(c2, j, j + 1);
                s2++;
            }
        }
        System.out.println(s1 > s2 ? s2 : s1);
    }

    public static void swap(char[] c, int i, int j) {
        char tmp = c[i];
        c[i] = c[j];
        c[j] = tmp;
    }
}
