package com.leetcode.other;

/**
 * Created by BIG-JIAN on 2017/7/25.
 */
public class P6_MergeSortedArray {
    public void merge(int A[], int m, int B[], int n) {
        if (A == null || B == null)
            return;
        int idx1 = m - 1;
        int idx2 = n - 1;
        int len = m + n - 1;
        while (idx1 >= 0 && idx2 >= 0) {
            if (A[idx1] > B[idx2]) {
                A[len--] = A[idx1--];
            } else {
                A[len--] = B[idx2--];
            }
        }
        while (idx2 >= 0) {
            A[len--] = B[idx2--];
        }
    }
}
