package com.jemmm.sort;

/**
 * Created by BIG-JIAN on 2017/7/8.
 */

import static com.jemmm.utils.CommonUtils.swap;
import static com.jemmm.utils.PrintfUtils.printf;

/**
 * Created by BIG-JIAN on 2017/7/8.
 */
public class BubbleSort {
    public static void main(String[] args) {
        int[] a = { 4, 5, 2, 3, 9, 8, 7, 6, 1 };
        bubbleSort(a);
        printf(a);
    }

    public static int[] bubbleSort(int[] a) {
        // 每次沉底一个
        for (int i = 0; i < a.length; i++) {
            for (int j = 0; j < a.length - i - 1; j++) {
                if (a[j] > a[j + 1]) {
                    swap(a, j, j + 1);
                }
            }
        }
        return a;
    }

    /*
     * 优化方案一：设置一个标志，如果这一趟发生了交换，则为true，否则为false。 明显如果有一趟没有发生交换，说明排序已经完成
     */
    public static int[] bubbleInsert2(int[] a) {
        boolean flag = true;
        for (int i = 0; i < a.length && flag; i++) {
            flag = false;
            for (int j = 0; j < a.length - i - 1; j++) {
                if (a[j] > a[j + 1]) {
                    swap(a, j, j + 1);
                    flag = true;
                }
            }
        }
        return a;
    }

    /*
     * 优化方法：如果有100个数，仅仅前面10个数是无序的，后面的都是有序的，请优化
     * 方法：在第一次遍历后，最后发生交换的位置必定小于10，并且这个位置之后的数据必定已经有序了，
     * 记录下这个位置，第二次只要从数组头部遍历到这个位置就可以了。
     */
    public static int[] bubbleInsert3(int[] a) {
        int k;
        int flag = a.length;
        for (int i = 0; i < a.length && flag > 0; i++) {
            k = flag;
            flag = 0;
            for (int j = 0; j < k - 1; j++) {
                if (a[j] > a[j + 1]) {
                    swap(a, j, j + 1);
                    flag = j + 1;
                }
            }
        }
        return a;
    }
}
