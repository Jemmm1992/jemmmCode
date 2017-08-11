package com.zhenti.pinduoduo;

import java.util.Arrays;
import java.util.Scanner;

/**
 * Created by BIG-JIAN on 2017/8/1.
 */
public class Main_3 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] h = new int[n];
        for (int i = 0; i < n; i++) {
            h[i] = sc.nextInt();
        }
        int m = sc.nextInt();
        int[] w = new int[m];
        for (int i = 0; i < m; i++) {
            w[i] = sc.nextInt();
        }
        Arrays.sort(h);
        Arrays.sort(w);
        int count = 0;
        int i = 0, j = 0;
        while (j < m && i < n) {
            if (h[i] <= w[j]) {
                count++;
                i++;
                j++;
            } else {
                j++;
            }
        }
        System.out.println(count);
    }
}

//3
//        2 2 3
//        2
//        3 1