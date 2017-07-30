package com.leetcode.linkedlist;



/**
 * A linked list is given such that each node contains an additional random pointer which could point to any node
 * in the list or null.
 * Return a deep copy of the list.
 */

/**
 * 思路：1.复制链表的每个节点。
 * 2.复制每个节点的Random节点。
 * 3.拆分链表。
 */
public class CopyListWithRandomPointer {
    public RandomListNode copyRandomList(RandomListNode head) {
        if (head == null) return null;
        copyNode(head);
        linkRandomPointer(head);
        splitNode(head);
        return null;
    }

    private void copyNode(RandomListNode head) {
        RandomListNode node = head;
        while (node != null) {
            RandomListNode copyNode = new RandomListNode(node.label);
            copyNode.next = node.next;
            node.next = copyNode;
            node = node.next.next;
        }
    }

    private void linkRandomPointer(RandomListNode head) {
        RandomListNode node = head;
        while(node != null){
            if(node.random!=null){
                node.next.random = node.random.next;
            }
            node = node.next.next;
        }
    }

    private RandomListNode splitNode(RandomListNode head) {
        RandomListNode node = head;
        RandomListNode copyHead = node.next;
        RandomListNode copy;

        while(node !=null){
            copy = node.next;
            node.next = copy.next;
            if(node.next != null){
                copy.next = node.next.next;
            }
            node = node.next;
        }
        return copyHead;
    }


    //Definition for singly-linked list with a random pointer.
    class RandomListNode {
        int label;
        RandomListNode next, random;

        RandomListNode(int x) {
            this.label = x;
        }
    }
}
