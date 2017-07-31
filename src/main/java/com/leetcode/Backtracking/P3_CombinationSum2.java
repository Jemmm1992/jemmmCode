package com.leetcode.Backtracking;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static com.utils.PrintfUtils.printf;

/**
 * Created by BIG-JIAN on 2017/7/29.
 */
public class P3_CombinationSum2 {
    public static void main(String[] args) {
        int[] a = {10, 1, 2, 7, 6, 1, 5};
        int traget = 8;
        printf(combinationSum2(a, traget));
    }

    public static List<List<Integer>> combinationSum2(int[] num, int target) {
        List<List<Integer>> res = new ArrayList<>();
        if (num == null || num.length == 0)
            return res;
        Arrays.sort(num);
        helper(num, 0, target, new ArrayList<>(), res, true);
        return res;
    }


    private void helper(int[] num, int start, int target, List<Integer> item,
                        List<List<Integer>> res) {
        if (target == 0) {
            res.add(new ArrayList<>(item));
            return;
        }
        if (target < 0 || start >= num.length)
            return;
        for (int i = start; i < num.length; i++) {
            if (i > start && num[i] == num[i - 1]) continue;
            item.add(num[i]);
            helper(num, i + 1, target - num[i], item, res);
            item.remove(item.size() - 1);
        }
    }

    /**
     * 小优化
     */
    private static void helper(int[] num, int start, int target, List<Integer> item,
                               List<List<Integer>> res, boolean flag) {
        if (target == 0) {
            res.add(new ArrayList<>(item));
            return;
        }
        if (target < 0 || start >= num.length) {
            flag = false;
            return;
        }
        for (int i = start; i < num.length && flag; i++) {
            // 过滤掉重复的选项，另外优化点：对于那些target开始小于0，后面就没有必要再次循环了
            if (i > start && num[i] == num[i - 1]) continue;
            item.add(num[i]);
            helper(num, i + 1, target - num[i], item, res, true);
            item.remove(item.size() - 1);
        }
    }
}
