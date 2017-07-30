package com.leetcode.partition;

/**
 * Created by BIG-JIAN on 2017/6/18.
 */

import java.util.ArrayList;
import java.util.HashSet;

import static com.jemmm.utils.CommonUtils.swap;
import static com.jemmm.utils.PrintfUtils.printf;

/**
 * Given a collection of numbers that might contain duplicates, return all possible unique Permutations.
 * For example,
 * [1,1,2]have the following unique Permutations:
 * [1,1,2],[1,2,1], and[2,1,1].
 *
 * 不是最优解
 */
public class Permutations_ii {
    public static void main(String[] args) {
        int[] a = {1, 2, 2};
        ArrayList<ArrayList<Integer>> arrayLists = permuteUnique(a);
        printf(arrayLists);
    }

    public static ArrayList<ArrayList<Integer>> permuteUnique(int[] num) {
        ArrayList<ArrayList<Integer>> lists = new ArrayList<ArrayList<Integer>>();
        dfs(lists, num, 0);
        return lists;
    }

    private static void dfs(ArrayList<ArrayList<Integer>> lists, int[] num, int k) {
        if (num.length == k) {
            ArrayList<Integer> list = new ArrayList<>();
            for (int i : num) {
                list.add(i);
            }
            lists.add(list);
            return;
        }
        HashSet<Integer> set = new HashSet<>();
        for (int i = k; i < num.length; i++) {
            if (set.add(num[i])) {
                swap(num, i, k);
                dfs(lists, num, k + 1);
                swap(num, i, k);
            }
        }
    }
}
