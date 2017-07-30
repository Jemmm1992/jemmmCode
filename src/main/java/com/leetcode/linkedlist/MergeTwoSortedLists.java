package com.leetcode.linkedlist;

import com.leetcode.common.ListNode;

/**
 * Created by xu_zj on 2017/6/28.
 * Merge two sorted linked lists and return it as a new list. The new list should be made by splicing together the nodes of the first two lists.
 */
public class MergeTwoSortedLists {
    public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
        if(l1 == null) return l2;
        if(l2 == null) return l1;
        ListNode head = new ListNode(0);
        ListNode last =head;
        while(l1!=null && l2!=null){
            if(l1.val < l2.val){
                last.next = l1;
                l1 = l1.next;
            }else{
                last.next = l2;
                l2 =l2.next;
            }
            last = last.next;
        }
        if(l1 != null) last.next = l1;
        if(l2 != null) last.next = l2;
        return head.next;
    }
}
