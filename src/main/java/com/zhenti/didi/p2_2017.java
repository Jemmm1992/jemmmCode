package com.zhenti.didi;

import java.util.Arrays;
import java.util.Comparator;
import java.util.HashSet;
import java.util.Scanner;

/**
 * Created by BIG-JIAN on 2017/8/26.
 */
public class p2_2017 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int m = sc.nextInt();
        int[] a = new int[n];
        for (int i = 0; i < n; i++) {
            a[i] = sc.nextInt();
        }
        Arrays.sort(a);
        int[][] b = new int[m][2];
        for (int i = 0; i < m; i++) {
            b[i][0] = sc.nextInt();
            b[i][1] = sc.nextInt();
        }
        Arrays.sort(b, new Comparator<int[]>() {
            @Override
            public int compare(int[] o1, int[] o2) {
                return o2[1] -                     o1[1];
            }
        });

        int max = 0;
        int j = 0;
        HashSet<Integer> set = new HashSet<>();
        for (int i = 0; i < m; i++) {
            if (j < n && !set.contains(i)) {
                if (a[j++] >= b[i][0]) {
                    set.add(i);
                    max += b[i][1];
                }
            }
        }
        System.out.println(max);
    }
}
