package com.jemmm.leetcode.greedy;

/**
 * Created by BIG-JIAN on 2017/7/5.
 * Given an array of non-negative integers, you are initially positioned at the first index of the array.
 * Each element in the array represents your maximum jump length at that position.
 * Your goal is to reach the last index in the minimum number of jumps.
 * For example:
 * Given array A =[2,3,1,1,4]
 * The minimum number of jumps to reach the last index is2. (Jump1step from index 0 to 1, then3steps to the last index.)
 */
public class JumpGameii {
    public static void main(String[] args) {
//        int[] A = {2,3,1,1,4};
        int[] A = {2,1};
        int jump = jump(A);
        System.out.println(jump);
    }
    public static  int jump(int[] A) {
        int[] minStep = new int[A.length];// 存放着到达个点的最小步数
        for(int i = 0 ; i < A.length; i++){
            for(int j = 1 ; j<= A[i] && i+j < minStep.length;j++){
                if(minStep[i+j] == 0) minStep[i+j] = minStep[i] + 1;
                if(i+j == A.length-1) break;
            }
        }
        return minStep[A.length-1];
    }
}
