package com.leetcode.partition;
import java.util.ArrayList;

import static com.utils.CommonUtils.swap;
import static com.utils.PrintfUtils.printf;
/**
 * Created by BIG-JIAN on 2017/6/18.
 */
/**
 * Given a collection of numbers, return all possible Permutations.
 * For example,
 * [1,2,3]have the following Permutations:
 * [1,2,3],[1,3,2],[2,1,3],[2,3,1],[3,1,2], and[3,2,1].
 */
public class Permutations {
    public static void main(String[] args) {
        int[] a = {1, 2, 3};
        ArrayList<ArrayList<Integer>> permute = permute(a);
        printf(permute);
    }

    public static ArrayList<ArrayList<Integer>> permute(int[] num) {
        ArrayList<ArrayList<Integer>> lists = new ArrayList<ArrayList<Integer>>();
        dfs(lists, num, 0);
        return lists;
    }

    private static void dfs(ArrayList<ArrayList<Integer>> lists, int[] num, int k) {
        if (k == num.length) {
            ArrayList<Integer> list = new ArrayList<Integer>();
            for (Integer i : num) {
                list.add(i);
            }
            lists.add(list);
        }

        for (int i = k; i < num.length; i++) {
            swap(num, i, k);
            dfs(lists, num, k + 1);
            swap(num, k, i);
        }
    }

}
