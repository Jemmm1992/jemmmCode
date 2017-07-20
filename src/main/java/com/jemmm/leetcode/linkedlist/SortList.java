package com.jemmm.leetcode.linkedlist;

import com.jemmm.leetcode.common.ListNode;

/**
 * Created by xu_zj on 2017/6/23.
 * Sort a linked list in O(n log n) time using constant space complexity.
 */

/**
 * 思路：符合要求的只有 归并排序
 */
public class SortList {
    public ListNode sortList(ListNode head) {
        if(head == null || head.next == null) return head;
        ListNode fast =head;
        ListNode slow = head;
        while(fast.next!= null && fast.next.next != null){
            fast = fast.next.next;
            slow = slow.next;
        }
        ListNode list2 = slow.next;
        slow.next = null;
        head = sortList(head);
        list2 = sortList(list2);
        return merge(head,list2);
    }

    public ListNode merge(ListNode list1,ListNode list2){
        if(list1 == null) return list2;
        if(list2 == null ) return list1;
        ListNode head = new ListNode(0);
        ListNode last = head;
        while(list1!=null && list2!=null){
            if(list1.val < list2.val){
                last.next = list1;
                list1 = list1.next;
            }else{
                last.next = list2;
                list2 = list2.next;
            }
            last = last.next;
        }
        if(list1 != null) last.next = list1;
        else if(list2 != null) last.next = list2;
        return head.next;
    }
}
