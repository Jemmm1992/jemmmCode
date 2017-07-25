package com.jemmm.leetcode.other;

import com.jemmm.leetcode.common.ListNode;

/**
 * Created by BIG-JIAN on 2017/7/24.
 */
public class P2_AddTwoNumbers {
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        int count = 0;
        ListNode header = new ListNode(0);
        ListNode node = header;
        while (l1 != null || l2 != null) {
            int k = 0;
            if (l1 != null) {
                k += l1.val;
                l1 = l1.next;
            }
            if (l2 != null) {
                k += l2.val;
                l2 = l2.next;
            }
            ListNode n = new ListNode((k + count) % 10);
            node.next = n;
            node = n;
            count = (k + count) / 10;
        }
        if (count == 1)
            node.next = new ListNode(1);
        return header.next;
    }
}
