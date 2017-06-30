package com.jemmm.leetcode.linkedlist;

import com.jemmm.leetcode.common.ListNode;

/**
 * Created by xu_zj on 2017/6/28.
 * Given a sorted linked list, delete all duplicates such that each element appear only once.
 * For example,
 * Given1->1->2, return1->2.
 * Given1->1->2->3->3, return1->2->3.
 */
public class removeDuplicatesFromSortedList {
    public ListNode deleteDuplicates(ListNode head) {
        if(head == null) return head;
        ListNode pre = head;
        ListNode cur = head.next;
        while(cur!=null)
        {
            if(cur.val == pre.val)
                pre.next = cur.next;
            else
                pre = cur;
            cur = cur.next;
        }
        return head;
    }
}
