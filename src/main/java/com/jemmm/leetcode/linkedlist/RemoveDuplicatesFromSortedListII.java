package com.jemmm.leetcode.linkedlist;

import com.jemmm.leetcode.common.ListNode;

/**
 * Created by xu_zj on 2017/6/28.
 * Given a sorted linked list, delete all nodes that have duplicate numbers, leaving only distinct numbers from the original list.
 * For example,
 * Given1->2->3->3->4->4->5, return1->2->5.
 * Given1->1->1->2->3, return2->3.
 */

/**
 * 思路：一般会改到链表头的题目就会需要一个辅助指针，是比较常见的技巧。
 */
public class RemoveDuplicatesFromSortedListII {
    public ListNode deleteDuplicates(ListNode head) {
        if(head == null) return head;
        ListNode helper = new ListNode(0);
        helper.next = head;
        ListNode pre = helper;
        ListNode cur = head;
        while(cur!=null) {
            while(cur.next!=null && pre.next.val==cur.next.val) {
                cur = cur.next;
            }
            if(pre.next==cur) {
                pre = pre.next;
            } else {
                pre.next = cur.next;
            }
            cur = cur.next;
        }
        return helper.next;
    }
}


