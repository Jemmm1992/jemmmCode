package com.prototype.sort;

import static com.utils.CommonUtils.swap;
import static com.utils.PrintfUtils.printf;

/**
 * Created by BIG-JIAN on 2017/7/8.
 */
public class QuickSort {

    public static void main(String[] args) {
        int[] a = {4, 5, 2, 2, 3, 3, 9, 8, 7, 6, 1};
        quickSort(a, 0, a.length - 1);
        printf(a);
    }

    private static void quickSort(int[] a, int low, int high) {
        if (low < high) {
            int mid = getMid2(a, low, high);
            quickSort(a, low, mid - 1);
            quickSort(a, mid + 1, high);
        }
    }

    /**
     * 以a[high]为基准
     */
    public static int getMid1(int[] a, int low, int high) {
        int flag = low;
        for (int i = low; i < high; i++) {
            if (a[i] <= a[high]) {
                swap(a, i, flag++);
            }
        }
        swap(a, high, flag);
        return flag;
    }

    /**
     * 以a[low]为基准
     */
    private static int getMid2(int[] a, int low, int high) {
        int tmp = a[low], i = low, j = high;
        while (i < j) {
            while (i < high && a[i] <= tmp) i++;
            while (j >= low && a[j] > tmp) j--;
            if (i < j) swap(a, i, j);
        }
        swap(a, j, low);
        return j;
    }

}
