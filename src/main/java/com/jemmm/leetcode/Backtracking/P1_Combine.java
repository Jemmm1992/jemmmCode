package com.jemmm.leetcode.Backtracking;

import java.util.ArrayList;
import java.util.List;

import static com.jemmm.utils.PrintfUtils.printf;

/**
 * Created by BIG-JIAN on 2017/7/29.
 */
public class P1_Combine {
    public static void main(String[] args) {
        List<List<Integer>> combine = combine(4, 2);
        printf(combine);
    }

    public static List<List<Integer>> combine(int n, int k) {
        List<List<Integer>> res = new ArrayList<>();
        if (n <= 0 || n < k)
            return res;
        dfs(1, n, k, new ArrayList<>(), res);
        return res;
    }


    private static void dfs(int start, int n, int k, ArrayList<Integer> item, List<List<Integer>> res) {
        if (item.size() == k) {
            res.add(new ArrayList<>(item));
            return;
        }
        for (int i = start; i <= n; i++) {
            item.add(i);
            dfs(i + 1, n, k, item, res);
            item.remove(item.size() - 1);
        }
    }
}
