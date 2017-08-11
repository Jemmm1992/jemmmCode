package com.zhenti.wangyi;

import java.util.Scanner;

/**
 * Created by BIG-JIAN on 2017/8/8.
 */
public class p2_dache {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] tx = new int[n];
        int[] ty = new int[n];
        for (int i = 0; i < n; i++) {
            tx[i] = sc.nextInt();
        }
        for (int j = 0; j < n; j++) {
            ty[j] = sc.nextInt();
        }
        int gx = sc.nextInt();
        int gy = sc.nextInt();
        int walkTime = sc.nextInt();
        int taxiTime = sc.nextInt();

        int walkSum = (Math.abs(gx) + Math.abs(gy)) * walkTime;
        int taxiSum = walkSum;
        for (int i = 0; i < n; i++) {
            int s1 = (Math.abs(tx[i]) + Math.abs(ty[i])) * walkTime;
            int s2 = (Math.abs(tx[i] - gx) + Math.abs(ty[i] - gy)) * taxiTime;
            taxiSum = Math.min((s1 + s2), taxiSum);
        }
        System.out.println(taxiSum);
    }
}
