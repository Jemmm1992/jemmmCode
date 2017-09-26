package com.zhenti.kedaxunfei;

import java.util.Scanner;

/**
 * Created by BIG-JIAN on 2017/9/16.
 */
public class a11 {
    public static void main(String[] args) {
//        String s = "LRRLRL";
        Scanner sc = new Scanner(System.in);
        String s = sc.nextLine();
        Integer[] a = new Integer[1];
        a[0] = s.length();
        bfs(s, a);
        System.out.println(a[0]);
    }

    public static void bfs(String s, Integer[] a) {
        System.out.println(s);
        if (check(s)) {
            a[0] = Math.min(a[0], s.length());
            return;
        }
        bfs(s.replaceFirst("RL", "R"), a);
        bfs(s.replaceFirst("RL", "L"), a);
    }

    public static boolean check(String s) {
        if (s.contains("RL")) return false;
        else return true;
    }
}
