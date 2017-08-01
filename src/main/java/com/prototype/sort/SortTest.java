package com.prototype.sort;

import static com.utils.CommonUtils.swap;
import static com.utils.PrintfUtils.printf;

/**
 * Created by xu_zj on 2017/7/20.
 */
public class SortTest {
    public static void main(String[] args) {
        int[] a = {4, 5, 2, 3, 9, 8, 7, 6, 1};
        printf(a);
        getMax(a,a.length);
        printf(a);
    }

    public static void getMax(int [] a,int length){
        adjustHeap(a,length);
        for(int i = 0 ; i < length;i++){
            swap(a,0,length-1-i);
            adjustHeap(a,length-1-i);
        }
    }

    public static void adjustHeap(int[] a, int len) {
        int start = (len - 2) / 2;
        for (int i = start; i >= 0; i--) {
            int j = i;
            while (2 * j + 1 < len) {
                int child = 2 * j + 1;
                if (2 * j + 2 < len && a[child + 1] > a[child]) {
                    child += 1;
                }
                if (a[child] > a[j]) {
                    swap(a, child, j);
                }
                j = child;
            }
        }
    }

    public static void bubble(int[] a) {
        // 每次沉底一个
        for (int i = 0; i < a.length; i++) {
            for (int j = 0; j < a.length - i - 1; j++) {
                if (a[j] > a[j + 1]) swap(a, j, j + 1);
            }
        }
    }

    public static void insert(int[] a) {
        for (int i = 1; i < a.length; i++) {
            for (int j = i; j > 0; j--) {
                if (a[j] < a[j - 1]) swap(a, j, j - 1);
            }
        }
    }

    public static void select(int[] a) {
        for (int i = 0; i < a.length; i++) {
            for (int j = i; j < a.length; j++) {
                if (a[j] < a[i]) swap(a, j, i);
            }
        }
    }



}
