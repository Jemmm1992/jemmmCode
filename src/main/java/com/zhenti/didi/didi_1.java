package com.zhenti.didi;

import java.util.Scanner;

/**
 * Created by BIG-JIAN on 2017/8/26.
 */
public class didi_1 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int max = Integer.MIN_VALUE;
        String[] s = sc.nextLine().split(" ");
        int[] a = new int[s.length];
        for (int i = 0; i < s.length; i++) {
            a[i] = Integer.valueOf(s[i]);
        }
        int tmp = 0;
        for (int i = 0; i < s.length; i++) {
            tmp += a[i];
            max = Math.max(max, tmp);
            if (tmp < 0) {
                tmp = 0;
            }
        }
        System.out.println(max);
    }
}
