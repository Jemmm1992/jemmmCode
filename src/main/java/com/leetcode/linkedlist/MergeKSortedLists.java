package com.leetcode.linkedlist;

/**
 * Created by BIG-JIAN on 2017/7/3.
 */

import com.leetcode.common.ListNode;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.PriorityQueue;

import static com.jemmm.utils.CommonUtils.arrayToListNode;
import static com.jemmm.utils.PrintfUtils.printfListNode;

/**
 * Merge k sorted linked lists and return it as one sorted list. Analyze and describe its complexity.
 */

/**
 * 思路：这里为了简化代码，使用的是java.util.PriorityQueue来作为堆.当然可以自己实现一个堆
 */
public class MergeKSortedLists {
    public static void main(String[] args) {
        int[] a = {1, 3, 4, 6};
        int[] b = {2, 6, 7, 8};
        int[] c = {1, 2, 3, 4, 5, 6};

        ListNode listNode1 = arrayToListNode(a);
        ListNode listNode2 = arrayToListNode(b);
        ListNode listNode3 = arrayToListNode(c);

        ArrayList<ListNode> lists = new ArrayList<>();

        lists.add(listNode1);
        lists.add(listNode2);
        lists.add(listNode3);

        ListNode listNode = mergeKLists(lists);
        printfListNode(listNode);

    }

    public static ListNode mergeKLists(ArrayList<ListNode> lists) {
        if (lists == null || lists.size() == 0) return null;
        if (lists.size() == 1) return lists.get(0);

        PriorityQueue<ListNode> PQ = new PriorityQueue<>(lists.size(),new Comparator<ListNode>() {
            @Override
            public int compare(ListNode o1, ListNode o2) {
                if (o1.val < o2.val) return -1;
                else if (o1.val == o2.val) return 0;
                else return 1;
            }
        });
        ListNode head = new ListNode(0);
        ListNode phead = head;
        for (ListNode list : lists) {
            if (list != null) PQ.offer(list);
        }
        while (!PQ.isEmpty()) {
            ListNode tmp = PQ.poll();
            phead.next = tmp;
            phead = phead.next;
            if (tmp.next != null) PQ.offer(tmp.next);
        }
        return head.next;
    }
}


