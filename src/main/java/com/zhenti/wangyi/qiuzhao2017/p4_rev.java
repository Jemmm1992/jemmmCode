package com.zhenti.wangyi.qiuzhao2017;

import java.util.Scanner;

/**
 * Created by BIG-JIAN on 2017/8/12.
 */
public class p4_rev {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int s1 = sc.nextInt();
        int s2 = sc.nextInt();
        int s = get(get(s1) + get(s2));
        System.out.println(s);
    }

    public static int get(int i) {
        while (i % 10 == 0) {
            i /= 10;
        }
        StringBuffer sb = new StringBuffer(String.valueOf(i));
        return Integer.valueOf(sb.reverse().toString());
    }
}
