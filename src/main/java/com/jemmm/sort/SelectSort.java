package com.jemmm.sort;

import static com.jemmm.utils.CommonUtils.swap;
import static com.jemmm.utils.PrintfUtils.printf;

/**
 * Created by BIG-JIAN on 2017/7/8.
 */
public class SelectSort {
    public static void main(String[] args) {
        int[] a = { 4, 5, 2, 3, 9, 8, 7, 6, 1 };
        selectSort(a);
        printf(a);
    }

    private static void selectSort(int[] a) {
        int tmpIndex;
        for (int i = 0; i < a.length; i++) {
            tmpIndex = i;
            for (int j = i; j < a.length; j++) {
                if (a[j] < a[tmpIndex])
                    tmpIndex = j;
            }
            swap(a, i, tmpIndex);
        }
    }

}
