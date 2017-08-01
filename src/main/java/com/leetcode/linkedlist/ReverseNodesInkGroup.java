package com.leetcode.linkedlist;

import com.modal.ListNode;

import static com.utils.CommonUtils.arrayToListNode;
import static com.utils.PrintfUtils.printfListNode;

/**
 * Created by xu_zj on 2017/6/29.
 * Given a linked list, reverse the nodes of a linked list k at a time and return its modified list.
 * If the number of nodes is not a multiple of k then left-out nodes in the end should remain as it is.
 * You may not alter the values in the nodes, only nodes itself may be changed.
 * Only constant memory is allowed.
 * For example,
 * Given this linked list:1->2->3->4->5
 * For k = 2, you should return:2->1->4->3->5
 * For k = 3, you should return:3->2->1->4->5
 */

public class ReverseNodesInkGroup {
    public static void main(String[] args) {
        int[] a = {1, 2, 3, 4, 5, 6, 7, 8, 9, 10,11};
        ListNode head = arrayToListNode(a);
        printfListNode(head);

        ListNode node = reverseKGroup(head, 3);
        printfListNode(node);
    }

    public static ListNode reverseKGroup(ListNode head, int k) {
        ListNode cur = head;
        int cnt = 0;
        // get next group
        while (cur != null && cnt != k) {
            cur = cur.next;
            cnt++;
        }
        if (cnt == k) {
            System.out.println("===" + cur.val);
            cur = reverseKGroup(cur, k);
//            System.out.println("cur = reverseKGroup(cur, k) ->" + "cur: " + cur.val );
//            printfListNode(cur);
            System.out.println("***" + cur.val);
            // reverse
            while (--cnt >= 0) {
                ListNode tmp = head.next;
                head.next = cur;
                cur = head;
                head = tmp;
            }
            head = cur;
        }
        return head;
    }
}
