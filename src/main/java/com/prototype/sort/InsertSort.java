package com.prototype.sort;

import static com.utils.CommonUtils.swap;
import static com.utils.PrintfUtils.printf;

/**
 * Created by BIG-JIAN on 2017/7/8.
 */
public class InsertSort {
    public static void main(String[] args) {
        int[] a = {4, 5, 2, 3, 9, 8, 7, 6, 1};
        InsertrSort1(a);
        printf(a);
    }

    /**
     * 无优化的方法
     */
    public static int[] InsertrSort1(int[] a) {
        for (int i = 0; i < a.length; i++) {
            for (int j = i; j > 0; j--) {
                if (a[j] < a[j - 1]) {
                    swap(a, j, j - 1);
                }
            }
        }
        return a;
    }


    /**
     * InsertrSort1的简洁版本
     */
    public static int[] InsertSort2(int[] a) {
        for (int i = 0; i < a.length; i++) {
            for (int j = i - 1; j >= 0 && a[j + 1] < a[j]; j--) {
                swap(a, j, j + 1);
            }
        }
        return a;
    }
}
