package com.leetcode.Backtracking;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Created by BIG-JIAN on 2017/7/30.
 */
public class P6_SubSets2 {
    public static void main(String[] args) {
        int[] a = {1, 2, 2, 3};
        List<List<Integer>> lists = subsetsWithDup(a);
        System.out.println(lists);
    }

    public static List<List<Integer>> subsetsWithDup(int[] nums) {
        List<List<Integer>> list = new ArrayList<>();
        Arrays.sort(nums);
        dfs(list, new ArrayList<>(), nums, 0);
        return list;
    }

    private static void dfs(List<List<Integer>> list, List<Integer> tempList, int[] nums, int start) {
        list.add(new ArrayList<>(tempList));
        for (int i = start; i < nums.length; i++) {
            if (i > start && nums[i] == nums[i - 1]) continue; // skip duplicates
            tempList.add(nums[i]);
            dfs(list, tempList, nums, i + 1);
            tempList.remove(tempList.size() - 1);
        }
    }
}
