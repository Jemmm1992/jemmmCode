package com.jemmm.utils;

import com.jemmm.leetcode.common.ListNode;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by BIG-JIAN on 2017/6/18.
 */
public class Utils {
    /**
     * 输出数组
     */
    public static void printf(ArrayList<ArrayList<Integer>> lists){
        for (List<Integer> list: lists) {
            for (Integer i :list) {
                System.out.printf("%5d",i);
            }
            System.out.println();
        }
    }


    public static void printf(int [] a){
            for (Integer i :a) {
                System.out.printf("%5d",i);
            }
            System.out.println();
    }


    /**
     * 交换数组中的两个数
     * @param a
     * @param i
     * @param j
     */
    public static void swap(int[] a,int i,int j){
        int tmp = a[i];
        a[i] = a[j];
        a[j] = tmp;
    }

    /**
     * 直接将一个整形数组转化成对应的链表
     * @param a
     * @return
     */
    public static ListNode arrayToListNode(int [] a){
        ListNode head= new ListNode(0);
        ListNode n = head;
        for (Integer o:a) {
            ListNode node = new ListNode(o);
            n.next = node;
            n = n.next;
        }
        return head.next;
    }

    /**
     * 打印链表
     * @param head
     */
    public static void printfListNode(ListNode head){
        ListNode n = head;
        while(n != null){
            System.out.print(n.val + " -> ");
            n = n.next;
        }
        System.out.println("null");
    }
}
