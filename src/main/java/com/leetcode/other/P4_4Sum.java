package com.leetcode.other;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;

import static com.utils.PrintfUtils.printf;

/**
 * Created by BIG-JIAN on 2017/7/25.
 * http://blog.csdn.net/linhuanmars/article/details/24826871
 * http://blog.csdn.net/tofu_jelly/article/details/42393303
 */
public class P4_4Sum {
    public static void main(String[] args) {
        int[] a = {1, 0, -1, 0, -2, 2};
        ArrayList<ArrayList<Integer>> arrayLists = fourSum2(a, 0);
        printf(arrayLists);
    }

    public static ArrayList<ArrayList<Integer>> fourSum2(int[] num, int target) {
        ArrayList<ArrayList<Integer>> st = new ArrayList<>();
        HashSet<ArrayList<Integer>> set = new HashSet<>();
        if (num.length <= 3) return st;

        Arrays.sort(num);
        int sum;
        for (int i = 0; i < num.length - 3; i++) {
            for (int j = i + 1; j < num.length - 2; j++) {  //j要从i+1开始，否则会出现重复，并且hashset检测不出来
                int low = j + 1;    //从j + 1开始
                int high = num.length - 1;
                while (low < high) {
                    sum = num[i] + num[j] + num[low] + num[high];
                    if (sum == target) {
                        ArrayList<Integer> a = new ArrayList<>();
                        a.add(num[i]);
                        a.add(num[j]);
                        a.add(num[low]);
                        a.add(num[high]);
                        if (!set.contains(a)) { //只会检测每一位都一模一样的 比如1,0,-1和-1, 0, 1就检测不出来
                            set.add(a);
                            st.add(a);
                        }
                        low++;
                        high--;
                    } else {
                        if (sum < target) {
                            low++;
                        } else {
                            high--;
                        }
                    }
                }
            }
        }
        return st;
    }


    /**
     * 方法一：思路和方法三一样
     *
     * @param num
     * @param target
     * @return
     */
    public static ArrayList<ArrayList<Integer>> fourSum(int[] num, int target) {
        ArrayList<ArrayList<Integer>> res = new ArrayList<>();
        if (num == null || num.length == 0)
            return res;
        Arrays.sort(num);
        for (int i = num.length - 1; i > 2; i--) {
            if (i == num.length - 1 || num[i] != num[i + 1]) {
                ArrayList<ArrayList<Integer>> curRes = threeSum(num, i - 1, target - num[i]);
                for (int j = 0; j < curRes.size(); j++) {
                    curRes.get(j).add(num[i]);
                }
                res.addAll(curRes);
            }
        }
        return res;
    }

    private static ArrayList<ArrayList<Integer>> threeSum(int[] num, int end, int target) {
        ArrayList<ArrayList<Integer>> res = new ArrayList<>();
        for (int i = end; i > 1; i--) {
            if (i == end || num[i] != num[i + 1]) {
                ArrayList<ArrayList<Integer>> curRes = twoSum(num, i - 1, target - num[i]);
                for (int j = 0; j < curRes.size(); j++) {
                    curRes.get(j).add(num[i]);
                }
                res.addAll(curRes);
            }
        }
        return res;
    }

    private static ArrayList<ArrayList<Integer>> twoSum(int[] num, int end, int target) {
        ArrayList<ArrayList<Integer>> res = new ArrayList<>();
        int l = 0;
        int r = end;
        while (l < r) {
            if (num[l] + num[r] == target) {
                ArrayList<Integer> item = new ArrayList<>();
                item.add(num[l]);
                item.add(num[r]);
                res.add(item);
                l++;
                r--;
                while (l < r && num[l] == num[l - 1])
                    l++;
                while (l < r && num[r] == num[r + 1])
                    r--;
            } else if (num[l] + num[r] > target) {
                r--;
            } else {
                l++;
            }
        }
        return res;
    }
}
