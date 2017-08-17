package com.zhenti.wangyi.qiuzhao2018;

import java.util.*;

/**
 * Created by BIG-JIAN on 2017/8/13.
 */
public class p4_caozuoxulie {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] a = new int[n];
        List<Integer> l1 = new ArrayList<>();
        List<Integer> l2 = new ArrayList<>();

        for (int i = 0; i < n; i++) {
            if (i % 2 == 0) l1.add(sc.nextInt());
            else l2.add(sc.nextInt());
        }

        if (l1.size() > l2.size()) {
            Collections.reverse(l1);
            l1.addAll(l2);
            for (int i = 0; i < l1.size(); i++) {
                if (i == l1.size() - 1)
                    System.out.print(l1.get(i));
                else
                    System.out.print(l1.get(i) + " ");
            }
        } else {
            Collections.reverse(l2);
            l2.addAll(l1);
            for (int i = 0; i < l2.size(); i++) {
                if (i == l2.size() - 1)
                    System.out.print(l2.get(i));
                else
                    System.out.print(l2.get(i) + " ");
            }
        }

    }
}
