package com.leetcode.other;

import java.util.Arrays;
import java.util.HashMap;

import static com.utils.PrintfUtils.printf;

/**
 * Created by BIG-JIAN on 2017/7/24.
 */
public class P1_TwoSum {
    public static void main(String[] args) {
        int[] a = {2, 7, 11, 15};
        int[] a2 = {3, 2, 4};
        int[] ints = twoSum(a2, 6);
        int[] ints2 = twoSum2(a2, 6);
        printf(ints);
        printf(ints2);
    }

    //map里面放 键为target-每个数的结果 值为下标
    // 每次放入的时候看是否包含 当前值
    // 有的话说明当前值和已包含的值下标的那个元素为需要的结果
    public static int[] twoSum(int[] numbers, int target) {
        int n = numbers.length;
        int[] result = new int[2];
        HashMap<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < n; i++) {
            if (map.containsKey(numbers[i])) {
                result[0] = map.get(numbers[i]) + 1;
                result[1] = i + 1;
                break;
            } else {
                map.put(target - numbers[i], i);
            }
        }
        return result;
    }

    public static int[] twoSum2(int[] numbers, int target) {
        Arrays.sort(numbers);
        int l = 0, r = numbers.length - 1;
        int[] a = new int[2];
        while (l < r) {
            if (numbers[l] + numbers[r] == target) {
                a[0] = l ;
                a[1] = r + 1;
                break;
            } else if (numbers[l] + numbers[r] > target) {
                r--;
            } else {
                l++;
            }
        }
        return a;
    }
}
