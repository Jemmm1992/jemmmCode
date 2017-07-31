package com.leetcode.greedy;

import java.util.Arrays;

/**
 * Created by BIG-JIAN on 2017/7/30.
 * There are N children standing in a line. Each child is assigned a rating value.
 * You are giving candies to these children subjected to the following requirements:
 * Each child must have at least one candy. Children with a higher rating get more candies than their
 * neighbors. What is the minimum candies you must give?
 * 这题要求每个小孩至少要领到一颗糖果，但是高级别的小孩要比它旁边的孩子得到的糖果多（小孩的世界
 * 也有不平等了），问最少需要发多少糖果？
 */
public class P4_Candy {
    public int candy(int[] ratings) {
        int[] candys = new int[ratings.length];
        Arrays.fill(candys, 1);// 没人发一个糖
        for (int i = 1; i < ratings.length; i++) {
            if (ratings[i] > ratings[i - 1])
                candys[i] = candys[i - 1] + 1;
        }
        for (int i = ratings.length - 2; i >= 0; i--) {
            if (ratings[i] > ratings[i + 1] && candys[i] <= candys[i + 1])
                candys[i] = candys[i + 1] + 1;
        }
        int n = 0;
        for (int i = 0; i < candys.length; i++) {
            n += candys[i];
        }
        return n;
    }
}
