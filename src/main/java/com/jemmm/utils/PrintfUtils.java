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
    public static void printf(ArrayList<ArrayList<Integer>> lists){
        for (List<Integer> list: lists) {
            for (Integer i :list) {
                System.out.printf("%5d",i);
            }
            System.out.println();
        }
    }

    public static void printf(int id, String s){
        System.out.printf("%d,%s",id,s);
        System.out.println();
    }

    public static void printf( String s){
        System.out.printf("%s",s);
        System.out.println();
    }

    public static void printf(String title, String content){
        System.out.printf("%s: %s",title,title);
        System.out.println();
    }

    public static void printf(int [] a){
            for (Integer i :a) {
                System.out.printf("%5d",i);
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
