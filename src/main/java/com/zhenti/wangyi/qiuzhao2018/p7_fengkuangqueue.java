package com.zhenti.wangyi.qiuzhao2018;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.Scanner;

/**
 * Created by BIG-JIAN on 2017/8/13.
 */
public class p7_fengkuangqueue {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] a = new int[n];
        for (int i = 0; i < n; i++) {
            a[i] = sc.nextInt();
        }
        Arrays.sort(a);
        LinkedList<Integer> list = new LinkedList<>();
        list.add(a[n - 1]);
        int k = 1, v = 0;
        while (k < n) {
            list.addFirst(a[v]);
            k++;
            if (k == n) break;
            list.add(a[v + 1]);
            k++;
            if (k == n) break;
            list.addFirst(a[n - 2 - v]);
            k++;
            if (k == n) break;
            list.add(a[n - 3 - v]);
            k++;
            if (k == n) break;
            v += 2;
        }
        int sum = 0;
        for (int i = 1; i < n; i++) {
            sum += Math.abs(list.get(i - 1) - list.get(i));
        }
        System.out.println(sum);
    }
}
