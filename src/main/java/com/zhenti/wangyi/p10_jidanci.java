package com.zhenti.wangyi;

import java.util.HashSet;
import java.util.Scanner;

/**
 * Created by BIG-JIAN on 2017/8/9.
 */
public class p10_jidanci {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int m = sc.nextInt();
        sc.nextLine();
        String[] sn = sc.nextLine().split(" ");
        String[] sm = sc.nextLine().split(" ");
        HashSet<String> set = new HashSet<>();
        for (int i = 0; i < n; i++) {
            set.add(sn[i]);
        }
        int sum = 0;
        for (int i = 0; i < m; i++) {
            if (set.contains(sm[i])) {
                sum += sm[i].length() * sm[i].length();
            }
        }
        System.out.println(sum);

    }
}