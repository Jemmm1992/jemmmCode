package com.leetcode.linkedlist;

import com.leetcode.common.ListNode;

/**
 * Created by xu_zj on 2017/6/28.
 * Given a list, rotate the list to the right by k places, where k is non-negative.
 * For example:
 * Given1->2->3->4->5->NULL and k =2,
 * return4->5->1->2->3->NULL.
 */

/**
 * 题意：倒着数k个node，从那开始到结尾和之前那部分对调，那个例子就是，4->5拿前面来，1->2->3拿后面去。
 * 注意点：
 * 1. k是可以大于整个list的长度的，所以这时要对k对len取模
 * 2. 如果取模之后得0，相当于不用rotate，直接返回
 */
public class RotateList {
    public ListNode rotateRight(ListNode head, int n) {
        if (head == null || head.next == null || n == 0)
            return head;
        ListNode fast = head, slow = head, countlen = head;
        int len = 0;
        while (countlen != null) {
            len++;
            countlen = countlen.next;
        }
        n = n % len;
        if (n == 0)
            return head;
        for (int i = 0; i < n; i++)
            fast = fast.next;
        while (fast.next != null) {
            slow = slow.next;
            fast = fast.next;
        }
        ListNode newhead = slow.next;
        fast.next = head;
        slow.next = null;
        return newhead;
    }
}
