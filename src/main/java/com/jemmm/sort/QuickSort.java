package com.jemmm.sort;

import static com.jemmm.utils.CommonUtils.swap;
import static com.jemmm.utils.PrintfUtils.printf;

/**
 * Created by BIG-JIAN on 2017/7/8.
 */
public class QuickSort {

    public static void main(String[] args) {
        int[] a = { 4, 5, 2, 2, 3, 3, 9, 8, 7, 6, 1 };
        quickSort(a, 0, a.length - 1);
        printf(a);
    }

    private static void quickSort(int[] a, int low, int high) {
        if (low < high) {
            int mid = partition2(a, low, high);
            quickSort(a, low, mid - 1);
            quickSort(a, mid + 1, high);
        }
    }

    public static int partition(int[] a, int low, int high) {
        int flag = low;
        // 以a[high]为基准 划分
        for (int i = low; i < high; i++) {
            if (a[i] <= a[high]) {
                swap(a, i, flag++);
            }
        }
        swap(a, high, flag);
        return flag;
    }

    private static int partition2(int[] a, int low, int high) {
        int tmp = a[low];
        int i = low, j = high;
        while (i < j) {
            while (a[i] <= tmp && i < high) {
                i++;
            }
            while (a[j] > tmp && j >= low) {
                j--;
            }
            if (i < j) {
                swap(a, i, j);
            }
        }
        if (j != low) {
            swap(a, low, j);
        }
        return j;
    }

}
