package com.zhenti.wangyi;

import java.util.*;

/**
 * Created by BIG-JIAN on 2017/8/8.
 */
public class p4_quchong {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] a = new int[n];
        for (int i = 0; i < n; i++) {
            a[i] = sc.nextInt();
        }
        HashMap<Integer, Integer> map = new HashMap<>();
        for (int i = n - 1; i >= 0; i--) {
            if (map.get(a[i]) == null) {
                map.put(a[i], 1);
            } else {
                a[i] = 0;
            }
        }

        for (int i = 0; i < n; i++) {
            if (a[i] != 0) {
                if (i != n - 1) System.out.print(a[i] + " ");
                else System.out.print(a[i]);
            }
        }
    }
}
