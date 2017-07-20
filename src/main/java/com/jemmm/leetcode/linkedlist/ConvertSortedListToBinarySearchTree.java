package com.jemmm.leetcode.linkedlist;

import com.jemmm.leetcode.common.ListNode;
import com.jemmm.leetcode.common.TreeNode;


/**
 * Given a singly linked list where elements are sorted in ascending order, convert it to a height balanced BST.
 * 给定一个升序的单链表，将它转换成一颗高度平衡的二叉树
 */

/**
 * 思路：1.找中间结点，构建根结点，2.中间结点左半部分构建左子树，3.中间结点的右部分构建右子树
 */

public class ConvertSortedListToBinarySearchTree {

    public TreeNode sortedListToBST(ListNode head) {
        if (head == null) {
            return null;
        }
        if (head.next == null) {
            return new TreeNode(head.val);
        }
        ListNode fast = head.next.next;
        ListNode mid = head;
        while (fast != null && fast.next != null) {
            mid = mid.next;
            fast = fast.next.next;
        }
        TreeNode root = new TreeNode(mid.next.val);
        root.right = sortedListToBST(mid.next.next);
        ListNode midNext = mid.next;
        mid.next = null;
        root.left = sortedListToBST(head);
        mid.next = midNext;
        return root;
    }


}
