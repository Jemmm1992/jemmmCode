package com.leetcode.linkedlist;

import com.leetcode.common.ListNode;

/**
 * Created by xu_zj on 2017/6/28.
 * Given a linked list, return the node where the cycle begins. If there is no cycle, return null.
 * Follow up:
 * Can you solve it without using extra space?
 */

/**
 * 思路：
 * 1. 判断是否是有环链表->快慢指针
 * 2. 如果是有环链表，如何找到环的入口
 */
public class LinkedListCycleii {
    public ListNode detectCycle(ListNode head) {
        if(head== null) return null;
        ListNode fast = head;
        ListNode slow =head;
        while(fast.next!=null && fast.next.next!=null){
            fast =fast.next.next;
            slow = slow.next;
            if(fast == slow){
                fast = head;
                while(fast != slow){
                    fast = fast.next;
                    slow = slow.next;
                }
                return fast;
            }
        }
        return null;
    }
}
