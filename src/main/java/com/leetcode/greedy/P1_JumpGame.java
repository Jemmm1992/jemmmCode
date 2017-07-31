package com.leetcode.greedy;

/**
 * Created by BIG-JIAN on 2017/7/30.
 * Given an array of non-negative integers, you are initially positioned at the first index of the array.
 * Each element in the array represents your maximum jump length at that position.
 * Determine if you are able to reach the last index.
 * For example:
 * A = [2,3,1,1,4], return true.
 * A = [3,2,1,0,4], return false
 */
public class P1_JumpGame {
    public boolean canJump(int[] nums) {
        if (nums.length == 0) return true;
        int cur = nums[0];
        for (int i = 1; i < nums.length; i++) {
            cur--;
            if (cur < 0) return false;
            if (cur < nums[i]) cur = nums[i];
        }
        return true;
    }
}
