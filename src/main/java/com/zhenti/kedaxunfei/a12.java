package com.zhenti.kedaxunfei;

import java.util.Scanner;

/**
 * Created by BIG-JIAN on 2017/9/16.
 */
public class a12 {
    public static void main(String[] args) {
//        String s = "LRRLRL";
        Scanner sc = new Scanner(System.in);
        String s = sc.nextLine();
        repleace(s);
    }

    public static void repleace(String s) {
        while (s.contains("RL") || s.contains("*L") || s.contains("R*") || s.contains("**")) {
            s = s.replace("RL", "*").replace("*L", "*").replace("R*", "*").replace("**", "*");
        }
        System.out.println(s.length());
    }
}
