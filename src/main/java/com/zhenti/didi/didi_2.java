package com.zhenti.didi;

import java.util.Scanner;


/**
 * Created by BIG-JIAN on 2017/8/26.
 */
public class didi_2 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String[] s = sc.nextLine().split(" ");

        int[] a = new int[s.length];
        for (int i = 0; i < s.length; i++) {
            a[i] = Integer.valueOf(s[i]);
        }
        getMax(a, a.length);
        int n = Integer.valueOf(sc.nextLine());
        System.out.println(a[a.length - n]);

    }

    // 堆排序的思路
    // 建立堆，不断调整
    public static void getMax(int[] a, int length) {
        adjustHeap(a, length);
        for (int i = 0; i < length; i++) {
            swap(a, 0, length - 1 - i);
            adjustHeap(a, length - 1 - i);
        }
    }

    public static void adjustHeap(int[] a, int length) {
        int startIndex = (length - 2) / 2;
        for (int i = startIndex; i >= 0; i--) {
            int j = i;
            while (2 * j + 1 < length) {
                int child = 2 * j + 1;
                if (2 * j + 2 < length && a[child + 1] > a[child]) {
                    child += 1;
                }
                if (a[child] > a[j]) {
                    swap(a, child, j);
                }
                j = child;
            }
        }
    }

    public static void swap(int[] a, int i, int j) {
        int tmp = a[i];
        a[i] = a[j];
        a[j] = tmp;
    }
}
