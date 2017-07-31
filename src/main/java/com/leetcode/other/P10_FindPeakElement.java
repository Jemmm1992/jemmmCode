package com.leetcode.other;

/**
 * Created by BIG-JIAN on 2017/7/27.
 */
public class P10_FindPeakElement {
    public int findPeakElement(int[] nums) {
        int n = nums.length;
        if (n == 1) return 0;
        int start = 0;
        int end = n - 1;
        int mid = 0;
        while (start <= end) {
            mid = start + (end - start) / 2;
            if ((mid == 0 || nums[mid] >= nums[mid - 1]) && (mid == n - 1 || nums[mid] >= nums[mid + 1])) {
                return mid;
            } else if (mid > 0 && nums[mid - 1] > nums[mid]) {
                end = mid - 1;
            } else {
                start = mid + 1;
            }
        }
        return mid;
    }
}
