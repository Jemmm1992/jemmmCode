package com.jemmm.utils;

import com.jemmm.leetcode.common.ListNode;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by BIG-JIAN on 2017/6/18.
 */
public class PrintfUtils {
    /**
     * 输出数组
     */
    public static void printf(ArrayList<ArrayList<String>> lists) {
        for (List<String> list : lists) {
            for (Object i : list) {
                System.out.printf("%5d", i.toString());
            }
            System.out.println();
        }
    }


    public static void printf(int id, Object s) {
        System.out.printf("%d,%s", id, s.toString());
        System.out.println();
    }

    public static void printf(Object s) {
        System.out.printf("%s", s.toString());
        System.out.println();
    }

    public static void printf(String title, Object content) {
        System.out.printf("%s: %s", title, content.toString());
        System.out.println();
    }

    public static void printf(int[] a) {
        for (Integer i : a) {
            System.out.printf("%5d", i);
        }
        System.out.println();
    }

    public static void printf(int[][] a) {
        for (int i = 0; i < a.length; i++) {
            for (int j = 0; j < a[0].length; j++) {
                System.out.printf("%5d", a[i][j]);
            }
            System.out.println();
        }
    }

    /**
     * 打印链表
     *
     * @param head
     */
    public static void printfListNode(ListNode head) {
        ListNode n = head;
        while (n != null) {
            System.out.print(n.val + " -> ");
            n = n.next;
        }
        System.out.println("null");
    }
}
