package com.offer;

import java.util.*;

/**
 * Created by BIG-JIAN on 2017/8/22.
 */
public class Main2 {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] a = new int[n];
        for (int i = 0; i < n; i++) {
            a[i] = sc.nextInt();
        }
        List<List<Integer>> subset = subset(a);
        int max = Integer.MIN_VALUE;
        for (int i = 1; i < subset.size(); i++) {
            max = Math.max(max, getMax(subset.get(i)));
        }
        System.out.println(max);
    }


    public static int getMax(List<Integer> a) {
        Collections.sort(a);
        int sum = 0;
        for (Integer item : a) {
            System.out.print(item + " ");
            sum += item;
        }
        System.out.println();
        System.out.println(sum * a.get(0));
        return sum * a.get(0);
    }

    public static List<List<Integer>> subset(int[] nums) {
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
}
