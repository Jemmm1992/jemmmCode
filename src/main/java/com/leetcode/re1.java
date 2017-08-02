package com.leetcode;

import java.util.Arrays;

/**
 * Created by xu_zj on 2017/8/1.
 * Given a sorted array and a target value, return the index if the target is found. If not, return the index where it would be if it were inserted in order.
 * You may assume no duplicates in the array.
 * Here are few examples.
 * [1,3,5,6], 5 → 2
 * [1,3,5,6], 2 → 1
 * [1,3,5,6], 7 → 4
 * [1,3,5,6], 0 → 0
 */
public class re1 {
    public static void main(String[] args) {
        int[] a = {1, 3, 5, 6};
        System.out.println(searchInsert(a, 5));
        System.out.println(searchInsert(a, 2));
        System.out.println(searchInsert(a, 7));
        System.out.println(searchInsert(a, 0));
    }

    public static int searchInsert(int[] nums, int target) {
        int i = Arrays.binarySearch(nums, target);
        if (i < 0) return -i - 1;
        else return i;
    }
}
