package com.leetcode.Backtracking;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static com.utils.PrintfUtils.printf;

/**
 * Created by BIG-JIAN on 2017/7/29.
 */
public class P2_CombinationSum {
    public static void main(String[] args) {
        int[] a = {2, 3, 6, 7};
        int target = 7;
        List<List<Integer>> lists = combinationSum(a, target);
        printf(lists);
    }

    public static List<List<Integer>> combinationSum(int[] candidates, int target) {
        List<List<Integer>> res = new ArrayList<>();
        if (candidates == null || candidates.length == 0)
            return res;
        Arrays.sort(candidates);
        helper(candidates, 0, target, new ArrayList<>(), res);
        return res;
    }

    private static void helper(int[] candidates, int start, int target, ArrayList<Integer> item, List<List<Integer>> res) {
        if (target < 0)
            return;
        if (target == 0) {
            res.add(new ArrayList<>(item));
            return;
        }
        for (int i = start; i < candidates.length; i++) {
//            if (i > 0 && candidates[i] == candidates[i - 1]) continue;
            item.add(candidates[i]);
            helper(candidates, i, target - candidates[i], item, res);
            item.remove(item.size() - 1);
        }
    }
}
