package com.leetcode.linkedlist;

/**
 * Created by xu_zj on 2017/6/28.
 */

import com.leetcode.common.ListNode;

/**
 Reverse a linked list from position m to n. Do it in-place and in one-pass.
 For example:
 Given1->2->3->4->5->NULL, m = 2 and n = 4,
 return1->4->3->2->5->NULL.
 Note:
 Given m, n satisfy the following condition:
 1 ≤ m ≤ n ≤ length of list.
 */
/**思路：
 * 第一步是找到m结点所在位置，
 * 第二步就是进行反转直到n结点。
 * 反转的方法就是每读到一个结点，把它插入到m结点前面位置，然后m结点接到读到结点的下一个。
 */
public class _ReverseLinkedListii {
    public ListNode reverseBetween(ListNode head, int m, int n) {
        if(head == null) return null;
        ListNode node = new ListNode(0);
        node.next = head;
        ListNode preNode = node;
        int i=1;
        while(preNode.next!=null && i<m)
        {
            preNode = preNode.next;
            i++;
        }
        if(i<m) return head;
        ListNode p1 = preNode.next;
        ListNode cur = p1.next;
        while(cur!=null && i<n)
        {
            ListNode next = cur.next;
            cur.next = preNode.next;
            preNode.next = cur;
            p1.next = next;
            cur = next;
            i++;
        }
        return node.next;
    }
}
