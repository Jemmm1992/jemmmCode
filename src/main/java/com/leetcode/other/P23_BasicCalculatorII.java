package com.leetcode.other;

import java.util.Stack;

/**
 * Created by BIG-JIAN on 2017/7/28.
 */
public class P23_BasicCalculatorII {


    public static void main(String[] args) {
        String s = "12+3*4+10";
        System.out.println(calculate(s));
    }

    public static int calculate(String s) {
        Stack<Integer> stack = new Stack<>();
        int res = 0, num = 0;
        char op = '+';
        char[] cArray = s.toCharArray();
        for (int i = 0; i < cArray.length; i++) {
            char c = cArray[i];
            if (c >= '0' && c <= '9') num = num * 10 + c - '0';
            if (c == '+' || c == '-' || c == '*' || c == '/' || i == cArray.length - 1) {
                if (op == '-') stack.push(-num);
                if (op == '+') stack.push(num);
                if (op == '*') stack.push(stack.pop() * num);
                if (op == '/') stack.push(stack.pop() / num);
                op = c;
                num = 0;
            }
        }
        for (int i : stack) {
            res += i;
        }
        return res;
    }
}
