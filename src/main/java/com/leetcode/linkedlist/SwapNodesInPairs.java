package com.leetcode.linkedlist;

/**
 * Created by BIG-JIAN on 2017/7/3.
 */

import com.modal.ListNode;

import static com.utils.CommonUtils.arrayToListNode;
import static com.utils.PrintfUtils.printfListNode;

/**
 * Given a linked list, swap every two adjacent nodes and return its head.
 * For example,
 * Given1->2->3->4, you should return the list as2->1->4->3.
 * Your algorithm should use only constant space. You may not modify the values in the list,
 * only nodes itself can be changed.
 */
public class SwapNodesInPairs {

    public static void main(String[] args) {
        int[] a= {1,2,3,4,5,6};
        ListNode listNode = arrayToListNode(a);
        printfListNode(listNode);
        ListNode listNode1 = swapPairs(listNode);
        printfListNode(listNode1);
    }

    public static ListNode swapPairs(ListNode head) {
        ListNode newHead = new ListNode(0);
        newHead.next = head;

        ListNode node = newHead;
        while(node!= null){
            swapListNode(node);
            if(node.next == null) break;
            node = node.next.next;
        }
        return newHead.next;
    }

    public static ListNode swapListNode(ListNode head){
        if(head.next == null || head.next.next == null) return head;
        ListNode node = head;
        ListNode n1 = node.next;
        node.next = n1.next;
        n1.next = node.next.next;
        node.next.next = n1;
        return head;
    }
}
