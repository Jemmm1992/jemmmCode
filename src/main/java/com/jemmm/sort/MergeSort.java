package com.jemmm.sort;

import static com.jemmm.utils.PrintfUtils.printf;

/**
 * Created by BIG-JIAN on 2017/7/8.
 */

public class MergeSort {

    public static void main(String[] args) {
        // int[] a = { 4, 5, 2, 3, 9, 8, 7, 6, 1 };
        int a[] = { 5, 4, 9, 8, 7, 6, 0, 1, 3, 2 };
        mergeSort(a, 0, a.length - 1);
        printf(a);
    }

    public static void mergeSort(int[] a, int low, int high) {
        int mid = (low + high) / 2;
        if (low < high) {
            mergeSort(a, low, mid);
            mergeSort(a, mid + 1, high);
            merge(a, low, mid, high);
        }
    }

    public static void merge(int[] a, int low, int mid, int high) {
        int i = low;
        int j = mid + 1;
        int[] tmp = new int[high - low + 1];
        int k = 0;
        while (i <= mid && j <= high) {
            if (a[i] < a[j]) {
                tmp[k++] = a[i++];
            } else {
                tmp[k++] = a[j++];
            }
        }
        while (i <= mid) {
            tmp[k++] = a[i++];
        }
        while (j <= high) {
            tmp[k++] = a[j++];
        }
        for (int v = 0; v < tmp.length; v++) {
            a[low + v] = tmp[v];
        }
    }
}
