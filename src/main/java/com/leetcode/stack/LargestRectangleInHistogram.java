package com.leetcode.stack;

import java.util.Stack;

/**
 * Created by BIG-JIAN on 2017/7/6.
 * 题目地址：https://www.nowcoder.com/practice/e3f491c56b7747539b93e5704b6eca40?tpId=46&tqId=29094&tPage=1&rp=1&ru=/ta/leetcode&qru=/ta/leetcode/question-ranking
 */
public class LargestRectangleInHistogram {
    public static void main(String[] args) {
        int[] height={2,1,5,6,2,2,2,3};
        int i = largestRectangleArea(height);
        System.out.println(i);
    }

    public static int largestRectangleArea(int[] height) {
        Stack<Integer> stack = new Stack<>();
        int i = 0,maxArea = 0;
        while(i <= height.length){
            int h =(i == height.length)?0:height[i];
            if(stack.isEmpty() || height[stack.peek()] <= h){
                stack.push(i++);
            }else{
                int t = stack.pop();
                if(stack.isEmpty()) System.out.println("**");
                maxArea = Math.max(maxArea,height[t] * (stack.isEmpty()?i:i-stack.peek()-1));
            }
        }
        return maxArea;
    }
    public static  int largestRectangleArea2(int[] height) {
        int len = height.length;
        Stack<Integer> s = new Stack<Integer>();
        int maxArea = 0;
        for(int i = 0; i <= len; i++){
            int h = (i == len ? 0 : height[i]);
            if(s.isEmpty() || h >= height[s.peek()]){
                s.push(i);
            }else{
                int tp = s.pop();
                maxArea = Math.max(maxArea, height[tp] * (s.isEmpty() ? i : i - 1 - s.peek()));
                System.out.println(maxArea);
                i--;
            }
        }
        return maxArea;
    }
}
