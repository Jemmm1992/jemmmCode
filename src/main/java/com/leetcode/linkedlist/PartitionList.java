package com.leetcode.linkedlist;

import com.leetcode.common.ListNode;

/**
 * Created by BIG-JIAN on 2017/6/28.
 * Given a linked list and a value x, partition it such that all nodes less than x come before nodes greater than or equal to x.
 * You should preserve the original relative order of the nodes in each of the two partitions.
 * For example,
 * Given1->4->3->2->5->2and x = 3,
 * return1->2->2->4->3->5.
 */
public class PartitionList {
    public static void main(String[] args) {
        ListNode n1 = new ListNode(1);
        ListNode n2 = new ListNode(1);
        n1.next = n2;
        ListNode partition = partition(n1, 0);
        while (partition != null) {
            System.out.println(partition.val);
            partition = partition.next;
        }
    }

    public static ListNode partition(ListNode head, int x) {
        ListNode lessHead = new ListNode(0);
        ListNode greaterHead = new ListNode(0);
        ListNode node = head, less = lessHead, greater = greaterHead;
        while (node != null) {
            // 这里注意，因为下面less和greater会断开链接，所以要先保存next
            ListNode next = node.next;
            if (node.val < x) {
                less.next = node;
                less = less.next;
                less.next = null;
            } else {
                greater.next = node;
                greater = greater.next;
                greater.next = null;
            }
            node = next;
        }
        less.next = greaterHead.next;
        return lessHead.next;
    }
}
