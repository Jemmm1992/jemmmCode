package com.leetcode.other;

import java.util.ArrayList;

import static com.utils.PrintfUtils.printf;

/**
 * Created by xu_zj on 2017/7/26.
 */
public class P21_GenerateParentheses {
    public static void main(String[] args) {
        ArrayList<String> strings = generateParenthesis(3);
        printf(strings);
    }

    public static ArrayList<String> generateParenthesis(int n) {
        ArrayList<String> res = new ArrayList<>();
        if (n <= 0) return res;
        helper(n, n, new String(), res);
        return res;
    }

    private static void helper(int l, int r, String item, ArrayList<String> res) {
        if (r < l) return;
        if (l == 0 && r == 0) res.add(item);
        if (l > 0) helper(l - 1, r, item + "(", res);
        if (r > 0) helper(l, r - 1, item + ")", res);
    }
}
