package com.zhenti.lianjia;

import java.util.Scanner;
import java.util.TreeSet;

/**
 * Created by BIG-JIAN on 2017/8/19.
 */
public class t3 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        TreeSet<Integer> set = new TreeSet<>();
        for (int i = 0; i < n; i++) {
            set.add(sc.nextInt());
        }
        System.out.println(set.size());
        int k = 0;
        for (Integer item : set) {
            if (k == set.size() - 1) System.out.println(item);
            else System.out.print(item + " ");
            k++;
        }
    }
}
//10
//20 40 32 67 40 20 89 300 400 15