package com.jemmm.leetcode.common;

/**
 * Created by xu_zj on 2017/6/23.
 */
//Definition for singly-linked list with a random pointer.
public class RandomListNode {
    public int label;
    public RandomListNode next, random;

    public RandomListNode(int x) {
        this.label = x;
    }
}
