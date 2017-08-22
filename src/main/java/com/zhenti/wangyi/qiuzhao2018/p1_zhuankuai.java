package com.zhenti.wangyi.qiuzhao2018;

import java.util.Arrays;
import java.util.Scanner;

/**
 * Created by BIG-JIAN on 2017/8/13.
 */
public class p1_zhuankuai {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        char[] c = sc.next().toCharArray();
        int cnt = 1;
        Arrays.sort(c);
        for (int i = 1; i < c.length; i++) {
            if (c[i - 1] != c[i]) cnt++;
        }
        if (cnt == 1) System.out.println(1);
        else if (cnt == 2) System.out.println(2);
        else System.out.println(0);
    }
}
