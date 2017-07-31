package com.leetcode.greedy;

/**
 * Created by BIG-JIAN on 2017/7/30.
 * Given an array of non-negative integers, you are initially positioned at the first index of the array.
 * Each element in the array represents your maximum jump length at that position.
 * Your goal is to reach the last index in the minimum number of jumps.
 * For example:
 * Given array A = [2,3,1,1,4]
 * The minimum number of jumps to reach the last index is 2. (Jump 1 step from index 0 to 1, then 3 steps to the last index.)
 * Note:
 * You can assume that you can always reach the last index.
 */
public class P2_JumpGame {
    public static void main(String[] args) {
        int[] a = {2, 3, 1, 1, 4};
        System.out.println(jump(a));
    }

    public static int jump(int[] nums) {
        int step = 0, cur = 0, next = 0;
        for (int i = 0; i < nums.length; ) {
            if (cur >= nums.length - 1) break;
            while (i <= cur) {
                next = Math.max(next, nums[i] + i);
                i++;
            }
            step++;
            cur = next;
        }
        return step;
    }

    public static int jump2(int[] nums) {
        int step = 0, cur = 0, next = 0, i = 0;
        while (i < nums.length) {
            if (cur >= nums.length - 1) break;
            while (i <= cur) {
                next = Math.max(next, nums[i] + i);//更新最远达到点
                i++;
            }
            step++;
            cur = next;
        }
        return step;
    }
}
