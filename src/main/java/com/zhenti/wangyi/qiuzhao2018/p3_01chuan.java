package com.zhenti.wangyi.qiuzhao2018;

import java.util.Scanner;

/**
 * Created by BIG-JIAN on 2017/8/13.
 */
public class p3_01chuan {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        char[] c = sc.next().toCharArray();
        int max = 0;
        int tmp = 1;
        for (int i = 1; i < c.length; i++) {
            if (c[i - 1] == c[i]) {
                max = max > tmp ? max : tmp;
                tmp = 1;
            } else {
                tmp++;
            }
        }
        max = max > tmp ? max : tmp;
        System.out.println(max);
    }
}
