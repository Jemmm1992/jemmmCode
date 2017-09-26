package com.zhenti.meituan;

import java.util.Scanner;

/**
 * Created by BIG-JIAN on 2017/9/14.
 */
public class a2 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        String[] a = new String[n];
        for (int i = 0; i < a.length; i++) {
            a[i] = sc.next();
        }
        int k = 0;
        for (int i = 0; i < a.length; i++) {
            for (int j = 0; j < a.length; j++) {
                if (i != j) {
                    if (check(a[i], a[j])) k++;
                }
            }
        }
        System.out.println(k);
    }

    public static boolean check(String s1, String s2) {
        long a = Long.valueOf(s1 + s2);
        String s = Long.toString(a, 7);
        if (s.charAt(s.length() - 1) == '0') {
            return true;
        } else {
            return false;
        }
    }
}
