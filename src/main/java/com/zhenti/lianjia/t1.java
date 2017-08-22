package com.zhenti.lianjia;

import java.util.Scanner;

/**
 * Created by BIG-JIAN on 2017/8/19.
 */
public class t1 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int[] a = new int[10];
        for (int i = 0; i < 10; i++) {
            a[i] = sc.nextInt();
        }
        int high = sc.nextInt() + 30;
        int cnt = 0;
        for (int i = 0; i < 10; i++) {
            if (high >= a[i]) cnt++;
        }
        System.out.println(cnt);
    }
}
//100 200 150 140 129 134 167 198 200 111
//110