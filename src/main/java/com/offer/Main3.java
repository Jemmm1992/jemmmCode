package com.offer;

import java.util.*;

/**
 * Created by BIG-JIAN on 2017/8/22.
 */
public class Main3 {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] a = new int[n];
        for (int i = 0; i < n; i++) {
            a[i] = sc.nextInt();
        }
        int max = Integer.MIN_VALUE;
        for (int step = 1; step <= n; step++) {
            for (int v = 0; v <= n - step; v++) {
                int min = Integer.MAX_VALUE;
                int s = 0;
                int k = step;
                for (int j = v; j < n && k > 0; j++, k--) {
                    min = Math.min(min, a[j]);
                    s += a[j];
                    max = Math.max(max, min * s);
                }
            }
        }
        System.out.println(max);
    }
}
