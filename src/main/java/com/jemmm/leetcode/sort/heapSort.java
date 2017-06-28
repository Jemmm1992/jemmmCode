package com.jemmm.leetcode.sort;

import java.util.Arrays;

import static com.jemmm.utils.Utils.printf;
import static com.jemmm.utils.Utils.swap;

/**
 * Created by xu_zj on 2017/6/27.
 */
public class heapSort {
    public static void main(String[] args) {
        int[] a = {2, 5, 1, 3, 4, 6, 7, 9, 8, 0};
        printf(a);
        adjustHeap(a, a.length);
        printf(a);
        getMax(a,a.length);
        printf(a);
        Arrays.sort(a);
        printf(a);
    }

    // 堆排序的思路
    // 建立堆，不断调整

    public static void getMax(int [] a,int length){
        adjustHeap(a,length);
        for(int i = 0 ; i < length;i++){
            swap(a,a[0],a[length-1]);
            adjustHeap(a,length-1);
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
}
