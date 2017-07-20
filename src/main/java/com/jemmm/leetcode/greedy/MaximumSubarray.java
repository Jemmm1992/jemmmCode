package com.jemmm.leetcode.greedy;

/**
 * Created by BIG-JIAN on 2017/7/5.
 * Find the contiguous subarray within an array (containing at least one number) which has the largest sum.
 * For example, given the array[−2,1,−3,4,−1,2,1,−5,4],
 * the contiguous subarray[4,−1,2,1]has the largest sum =6.
 * click to show more practice.
 * More practice:
 * If you have figured out the O(n) solution, try coding another solution using the divide and conquer approach, which is more subtle.
 */
public class MaximumSubarray {
    public static void main(String[] args) {
        int[] A = {-2, 1, -3, 4, -1, 2, 1, -5, 4};
        int i = maxSubArray(A);
        System.out.println(i);
    }

    public static int maxSubArray(int[] A) {
        if (A.length == 0) return 0;
        int[] dp = new int[A.length];// dp[i]表示以i结尾的最大sum值
        dp[0] = A[0];
        for (int i = 1; i < A.length; i++) {
            if (dp[i - 1] < 0) {
                dp[i] = A[i];
            } else {
                dp[i] = dp[i - 1] + A[i];
            }
        }
        int sum = dp[0];
        for (int i = 0; i < dp.length; i++) {
            sum = Math.max(dp[i], sum);
        }
        return sum;
    }

    /**
     * 方法二：
     * 从头开始累加，直到和为负。此时前面这段不能给后面的串带来正收益，应舍弃，sum清零
     * 然后在开始统计最大的sum.
     */
    public static int maxSubArray2(int[] A) {
        if (A.length == 0) return 0;
        int sum = 0, max = A[0];
        for (int i = 0; i < A.length; i++) {
            sum += A[i];
            if (max < sum) max = sum;
            if (sum < 0) sum = 0;
        }
        return max;
    }
}
