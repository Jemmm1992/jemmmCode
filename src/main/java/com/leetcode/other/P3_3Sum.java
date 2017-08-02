package com.leetcode.other;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static com.utils.PrintfUtils.printf;

/**
 * Created by BIG-JIAN on 2017/7/25.
 */
public class P3_3Sum {

    public static void main(String[] args) {
        int[] a = {-4, -2, -2, -2, 0, 1, 2, 2, 2, 3, 3, 4, 4, 6, 6};
        ArrayList<ArrayList<Integer>> arrayLists = threeSum(a);
        List<List<Integer>> arrayLists2 = threeSum2(a);
        printf(arrayLists);
        printf(arrayLists2);
    }

    public static List<List<Integer>> threeSum2(int[] nums) {
        List<List<Integer>> result = new ArrayList<>();
        if (nums == null || nums.length < 3) return result;
        Arrays.sort(nums);
        for (int i = 0; i < nums.length - 2; i++) {
            if (i == 0 || (i > 0 && nums[i] != nums[i - 1])) { //过滤重复
                int left = i + 1, right = nums.length - 1, sum = 0 - nums[i];
                while (left < right) {
                    if (nums[left] + nums[right] == sum) {
                        ArrayList<Integer> list = new ArrayList<>();
                        list.add(nums[i]);
                        list.add(nums[left]);
                        list.add(nums[right]);
                        result.add(list);
                        left++;
                        right--;
                        while (left < right && nums[left] == nums[left - 1]) left++; // 过滤重复
                        while (left < right && nums[right] == nums[right + 1]) right--; // 过滤重复
                    } else if (nums[left] + nums[right] > sum) right--;
                    else left++;
                }
            }
        }
        return result;
    }


    /**
     * [-4,-2,-2,-2,0,1,2,2,2,3,3,4,4,6,6]
     * 对应输出应该为:
     * [[-4,-2,6],[-4,0,4],[-4,1,3],[-4,2,2],[-2,-2,4],[-2,0,2]]
     * 你的输出为:
     * [[-4,-2,6],[-4,0,4],[-2,-2,4],[-4,1,3],[-4,2,2],[-2,0,2]]
     *
     * @param num
     * @return
     */
    public static ArrayList<ArrayList<Integer>> threeSum(int[] num) {
        ArrayList<ArrayList<Integer>> res = new ArrayList<>();
        if (num == null || num.length <= 2)
            return res;
        Arrays.sort(num);
        for (int i = num.length - 1; i >= 2; i--) {
            if (i < num.length - 1 && num[i] == num[i + 1]) continue;
            ArrayList<ArrayList<Integer>> curRes = twoSum(num, i - 1, -num[i]);
            for (int j = 0; j < curRes.size(); j++) {
                curRes.get(j).add(num[i]);
            }
            res.addAll(curRes);
        }
        return res;
    }

    private static ArrayList<ArrayList<Integer>> twoSum(int[] num, int end, int target) {
        ArrayList<ArrayList<Integer>> res = new ArrayList<>();
        if (num == null || num.length <= 1)
            return res;
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
                while (l < r && num[l] == num[l - 1]) l++;
                while (l < r && num[r] == num[r + 1]) r--;
            } else if (num[l] + num[r] > target) {
                r--;
            } else {
                l++;
            }
        }
        return res;
    }
}
