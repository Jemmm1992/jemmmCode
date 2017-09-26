package com.zhenti.meituan;

import java.util.Scanner;

/**
 * Created by BIG-JIAN on 2017/9/14.
 */
public class a3 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int tmp = 0;
        for (int i = 0; i < n; i++) {
            int t = sc.nextInt();
            if (i == n - 1) tmp = t;
        }
        if (tmp == 1) System.out.println("Alice");
        else System.out.println("Bob");
    }
}
