package com.leetcode.Backtracking;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Created by BIG-JIAN on 2017/7/30.
 */
public class P5_SubSets {
    public static void main(String[] args) {
        int[] a = {1, 2, 3};
        List<List<Integer>> subsets = subsets(a);
        System.out.println(subsets);
    }

    /**
     * 递归解法
     * https://discuss.leetcode.com/topic/46159/a-general-approach-to-backtracking-questions-in-java-subsets-
     * permutations-combination-sum-palindrome-partitioning/2
     * <p>
     */
    public static List<List<Integer>> subsets(int[] nums) {
        List<List<Integer>> list = new ArrayList<>();
        Arrays.sort(nums);
        backtrack(0, nums, list, new ArrayList<>());
        return list;
    }

    private static void backtrack(int start, int[] nums, List<List<Integer>> list, List<Integer> tempList) {
        list.add(new ArrayList<>(tempList));
        for (int i = start; i < nums.length; i++) {
            tempList.add(nums[i]);
            backtrack(i + 1, nums, list, tempList);
            tempList.remove(tempList.size() - 1);
        }
    }

    /**
     * http://blog.csdn.net/linhuanmars/article/details/24286377
     * Code_Ganker的方法：
     * 主要递推关系就是假设函数返回递归集合，现在加入一个新的数字，我们如何得到包含新数字的所有子集。
     * 其实就是在原有的集合中对每集合中的每个元素都加入新元素得到子集，然后放入原有集合中（原来的集合中的元素不用删除，因为他们也是合法子集）。
     * 而结束条件就是如果没有元素就返回空集（注意空集不是null，而是没有元素的数组）就可以了。
     * <p>
     * 递归的做法
     */
    public ArrayList<ArrayList<Integer>> subsets2(int[] num) {
        if (num == null)
            return null;
        Arrays.sort(num);
        return helper(num, num.length - 1);
    }

    private ArrayList<ArrayList<Integer>> helper(int[] num, int index) {
        if (index == -1) {
            ArrayList<ArrayList<Integer>> res = new ArrayList<>();
            ArrayList<Integer> elem = new ArrayList<>();
            res.add(elem);
            return res;
        }
        ArrayList<ArrayList<Integer>> res = helper(num, index - 1);
        int size = res.size();
        for (int i = 0; i < size; i++) {
            ArrayList<Integer> elem = new ArrayList<Integer>(res.get(i));
            elem.add(num[index]);
            res.add(elem);
        }
        return res;
    }

    /**
     * 其实非递归解法的思路和递归是一样的，只是没有回溯过程，也就是自无到有的一个个元素加进来，然后构造新的子集加入结果集中，代码如下：
     */

    public ArrayList<ArrayList<Integer>> subsets3(int[] S) {
        ArrayList<ArrayList<Integer>> res = new ArrayList<>();
        res.add(new ArrayList<>());
        if (S == null || S.length == 0)
            return res;
        Arrays.sort(S);
        for (int i = 0; i < S.length; i++) {
            for (int j = 0; j < res.size(); j++) {
                ArrayList<Integer> item = new ArrayList<>(res.get(j));
                item.add(S[i]);
                res.add(item);
            }
        }
        return res;
    }
}
