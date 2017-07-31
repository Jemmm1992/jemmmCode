package com.jemmm.utils;

import com.leetcode.common.ListNode;

/**
 * Created by xu_zj on 2017/6/30.
 */
public class CommonUtils {
    /**
     * 交换数组中的两个数
     * @param a
     * @param i
     * @param j
     */
    public static void swap(int[] a,int i,int j){
        int tmp = a[i];
        a[i] = a[j];
        a[j] = tmp;
    }

    /**
     * 直接将一个整形数组转化成对应的链表
     * @param a
     * @return
     */
    public static ListNode arrayToListNode(int [] a){
        ListNode head= new ListNode(0);
        ListNode n = head;
        for (Integer o:a) {
            ListNode node = new ListNode(o);
            n.next = node;
            n = n.next;
        }
        return head.next;
    }
}
