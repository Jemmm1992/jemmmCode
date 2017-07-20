package com.jemmm.sort;

import static com.jemmm.utils.CommonUtils.swap;
import static com.jemmm.utils.PrintfUtils.printf;

/**
 * Created by BIG-JIAN on 2017/7/8.
 */
public class InsertSort {
    public static void main(String[] args) {
        int[] a = { 4, 5, 2, 3, 9, 8, 7, 6, 1 };
        InsertSort2(a);
        printf(a);
    }

    public static int[] InsertrSort(int[] a) {
        // 每次往有序序列插入一个
        boolean flag;
        for (int i = 0; i < a.length; i++) {
            flag = true;
            for (int j = i; j > 0 && flag == true; j--) {
                if (a[j] < a[j - 1]) {
                    swap(a, j, j - 1);
                } else {
                    flag = false;
                }
            }
        }
        return a;
    }

    public static int[] InsertSort2(int[] a) {
        for (int i = 0; i < a.length; i++) {
            for (int j = i - 1; j >= 0 && a[j + 1] < a[j]; j--) {
                swap(a, j, j + 1);
            }
        }
        return a;
    }
}
