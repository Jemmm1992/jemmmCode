package com.jemmm.leetcode.other;

import java.util.Stack;

/**
 * Created by BIG-JIAN on 2017/7/25.
 */
public class P9_LongestValidParentheses {
    public static void main(String[] args) {
        String s = "(())";
        System.out.println(longestValidParentheses2(s));
    }

    public static int longestValidParentheses2(String s) {
        // 用于记录待匹配的左括号和右括号的位置
        Stack<Integer> st = new Stack<>();
        int max = 0;
        for (int i = 0; i < s.length(); i++) {
            // 如是当前字符是右括号，并且记录栈非空，并且前一个字符是左括号
            if (s.charAt(i) == ')' && !st.isEmpty() && s.charAt(st.peek()) == '(') {
                // 左括号出栈
                st.pop();
                // 求最大值
                max = Math.max(max, i - ((st.isEmpty()) ? -1 : st.peek()));
            }
            // 其它情况就将字符入栈
            else {
                st.push(i);
            }
        }
        return max;
    }

    /**
     * 动态规划法 Dynamic Programming
     * 动态规划法将大问题化为小问题，我们不一定要一下子计算出整个字符串中最长括号对，
     * 我们可以先从后向前，一点一点计算。
     * 假设d[i]是从下标i开始到字符串结尾最长括号对长度，s[i]是字符串下标为i的括号。
     * 如果s[i-1]是左括号，如果i + d[i] + 1是右括号的话，那d[i-1] = d[i] + 1。
     * 如果不是则为0。如果s[i-1]是右括号，因为不可能有右括号开头的括号对，所以d[i-1] = 0。
     */
    public int longestValidParentheses(String s) {
        int[] dp = new int[s.length()];
        int maxLen = 0;
        for (int i = s.length() - 2; i >= 0; i--) {
            if (s.charAt(i) == '(') {
                int end = i + dp[i + 1] + 1;
                if (end < s.length() && s.charAt(end) == ')') {
                    dp[i] = dp[i + 1] + 2;
                    if (end + 1 < s.length()) {
                        dp[i] += dp[end + 1];
                    }
                }
            }
            maxLen = Math.max(maxLen, dp[i]);
        }
        return maxLen;
    }
}
