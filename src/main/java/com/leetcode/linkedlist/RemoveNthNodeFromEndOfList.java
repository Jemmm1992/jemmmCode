package com.leetcode.linkedlist;

import com.leetcode.common.ListNode;

import static com.jemmm.utils.CommonUtils.arrayToListNode;
import static com.jemmm.utils.PrintfUtils.printfListNode;

/**
 * Created by BIG-JIAN on 2017/7/4.
 * Given a linked list, remove the n th node from the end of list and return its head.
 * For example,
 * Given linked list: 1->2->3->4->5, and n = 2.

 * After removing the second node from the end, the linked list becomes 1->2->3->5.
 * Note:
 * Given n will always be valid.
 * Try to do this in one pass.
 */
public class RemoveNthNodeFromEndOfList {

    public static void main(String[] args) {
        int[] a= {1,2,3,4,5,6};
        ListNode listNode = arrayToListNode(a);
        printfListNode(listNode);
        ListNode listNode1 = removeNthFromEnd(listNode, 6);
        printfListNode(listNode1);
    }

    public static ListNode removeNthFromEnd(ListNode head, int n) {
        ListNode newHead = new ListNode(0);
        newHead.next = head;
        ListNode n1 = head;
        ListNode n2 = newHead;

        while(n!=0){
            n1 = n1.next;
            n--;
        }
        while(n1 != null){
            n1 = n1.next;
            n2 = n2.next;
        }
        n2.next = n2.next.next;
        return newHead.next;
    }
}
