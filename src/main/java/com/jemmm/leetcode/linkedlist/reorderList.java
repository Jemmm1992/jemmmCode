package com.jemmm.leetcode.linkedlist;

import com.jemmm.leetcode.common.ListNode;

/**
 * Created by xu_zj on 2017/6/28.
 * Given a singly linked list L: L 0→L 1→…→L n-1→L n,
 * reorder it to: L 0→L n →L 1→L n-1→L 2→L n-2→…
 * You must do this in-place without altering the nodes' values.
 * For example,
 * Given{1,2,3,4}, reorder it to{1,4,2,3}.
 */

/**
 * 思路：
 * 1. 使用快慢指针来找到链表的中点，并将链表从中点处断开，形成两个独立的链表。
 * 2. 将第二个链翻转。
 * 3. 将第二个链表的元素间隔地插入第一个链表中。
 */
public class reorderList {
    public void reorderList(ListNode head) {
        if (head == null || head.next == null) return;
        ListNode fast = head;
        ListNode slow = head;
        while (fast.next != null && fast.next.next != null) {
            fast = fast.next.next;
            slow = slow.next;
        }
        ListNode head2 = slow.next;
        slow.next = null;
        //翻转第二个子链表
        ListNode cur = head2, post = cur.next;
        cur.next = null;
        while (post != null) {
            ListNode tmp = post.next;
            post.next = cur;
            cur = post;
            post = tmp;
        }
        head2 = cur;

        //将两个子链表合并
        ListNode node1 = head, node2 = head2;
        while (node2 != null) {
            ListNode tmp1 = node1.next;
            ListNode tmp2 = node2.next;
            node1.next = node2;
            node2.next = tmp1;
            node1 = tmp1;
            node2 = tmp2;
        }
    }
}
