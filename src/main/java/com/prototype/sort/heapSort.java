package com.prototype.sort;

import java.util.Arrays;
import java.util.PriorityQueue;

import static com.utils.CommonUtils.swap;
import static com.utils.PrintfUtils.printf;

/**
 * Created by xu_zj on 2017/6/27.
 */
public class heapSort {
    public static void main(String[] args) {
        int[] a = {2, 5, 1, 3, 4, 6, 7, 9, 8, 0};
        printf(a);
        adjustHeap(a, a.length);
        printf(a);
        getMax(a, a.length);
        printf(a);
        Arrays.sort(a);
        printf(a);

        heapSort(a);
        printf(a);

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
                if (2 * j + 2 < length && a[child + 1] > a[child]) child++;
                if (a[child] > a[j]) swap(a, child, j);
                j = child;
            }
        }
    }

    /**
     * 使用API堆排序
     */
    public static void heapSort2(int[] a) {
        // PriorityQueue的排序不是普通的排序，而是堆排序
        PriorityQueue<Integer> heap = new PriorityQueue<>();
        for (int i = 0; i < a.length; i++) {
            heap.add(a[i]);
        }
        // 打印的堆的顺序
        for (Integer item : heap) {
            System.out.print(item + " ");
        }
        System.out.println();
        // 从小到大来排序
        int len = heap.size();//这里之所以取出.size()大小，因为每一次poll()之后size大小都会变化，所以不能作为for循环的判断条件
        for (int i = 0; i < len; i++) {
            System.out.print(heap.poll() + " ");
        }
        System.out.println();
    }

    /**
     * 原先方法
     */

    public static void heapSort(int[] a) {
        int len = a.length - 1;
        int k = (len - 1) / 2;
        for (int i = k; i >= 0; i--) {
            adjustMaxHeap(a, i, len);
        }
        for (int i = 0; i <= len; i++) {
            swap(a, 0, len - i);
            adjustMaxHeap(a, 0, len - 1 - i);
        }
    }

    /*
     * 堆排序的步骤 1.先建堆 2.每次取出最小值，进行堆调整
     */
    private static void adjustMaxHeap(int[] a, int i, int len) {
        int child = 2 * i + 1;
        while (child <= len) {
            if (child + 1 <= len && a[child] < a[child + 1]) {
                child += 1;
            }
            if (a[i] < a[child]) {
                swap(a, i, child);
            }
            i = child;
            child = 2 * child + 1;
        }
    }
}
