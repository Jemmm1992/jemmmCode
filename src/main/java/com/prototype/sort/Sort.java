package com.prototype.sort;

import java.util.PriorityQueue;

import static com.utils.CommonUtils.swap;
import static com.utils.PrintfUtils.printf;

/**
 * Created by BIG-JIAN on 2017/8/5.
 */
public class Sort {
    public static void main(String[] args) {
        int[] a = {4, 5, 2, 3, 9, 8, 7, 6, 1};
        printf(a);
        heapSort(a);
        printf(a);
    }

    /**
     * 思路：堆排序的思路,建立堆，不断调整
     */

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
                if (2 * j + 2 < length && a[child + 1] > a[child]) {
                    child += 1;
                }
                if (a[child] > a[j]) swap(a, child, j);
                j = child;
            }
        }
    }


    /**
     * 堆排序
     */
    public static void heapSort(int[] a) {
        // PriorityQueue的排序不是普通的排序，而是堆排序
        PriorityQueue<Integer> heap = new PriorityQueue<>();
        for (int i = 0; i < a.length; i++) {
            heap.add(a[i]);
        }
        // 打印的堆的顺序
        for (Integer item : heap) {
        }
        System.out.println();

        // 从小到大来排序
        //这里之所以取出.size()大小，因为每一次poll()之后size大小都会变化，所以不能作为for循环的判断条件
        int len = heap.size();
        for (int i = 0; i < len; i++) {
            System.out.print(heap.poll() + " ");
        }
        System.out.println();
    }

    /**
     * 归并排序
     * 1.分化 2.合并
     */
    public static void mergeSort(int[] a, int low, int high) {
        if (low < high) {
            int mid = (low + high) / 2;
            mergeSort(a, low, mid);
            mergeSort(a, mid + 1, high);
            merge(a, low, mid, high);
        }
    }

    public static void merge(int[] a, int low, int mid, int high) {
        int[] newA = new int[high - low + 1];
        int i = low, j = mid + 1, k = 0;
        while (i <= mid && j <= high) {
            if (a[i] <= a[j]) newA[k++] = a[i++];
            else newA[k++] = a[j++];
        }
        while (i <= mid) newA[k++] = a[i++];
        while (j <= high) newA[k++] = a[j++];
        for (int v = 0; v < newA.length; v++) {
            a[low++] = newA[v];
        }
    }

    /**
     * 快排
     * 1.getMid
     * 2.递归
     */
    public static void quickSort(int[] a, int l, int r) {
        if (l < r) {
            int mid = getMid(a, l, r);
            quickSort(a, l, mid - 1);
            quickSort(a, mid + 1, r);
        }
    }

    private static int getMid(int[] a, int low, int high) {
        int tmp = a[low], i = low, j = high;
        while (i < j) {
            while (i < high && a[i] <= tmp) i++;
            while (j >= low && a[j] > tmp) j--;
            if (i < j) swap(a, i, j);
        }
        swap(a, j, low);
        return j;
    }

    /**
     * 冒泡法
     */
    public static void bubbleSort(int[] a) {
        int len = a.length;
        for (int i = 0; i < len; i++) {
            for (int j = 0; j < len - i - 1; j++) {
                if (a[j] > a[j + 1])
                    swap(a, j, j + 1);
            }
        }
    }

    /**
     * 直接插入法
     */
    public static void insertSort(int[] a) {
        int len = a.length;
        for (int i = 0; i < len; i++) {
            for (int j = i; j > 0 && a[j] < a[j - 1]; j--)
                swap(a, j, j - 1);
        }
    }

    /**
     * 选择排序法
     */
    public static void selectSort(int[] a) {
        for (int i = 0; i < a.length; i++) {
            for (int j = i; j < a.length; j++) {
                if (a[j] < a[i]) swap(a, j, i);
            }
        }
    }


}
