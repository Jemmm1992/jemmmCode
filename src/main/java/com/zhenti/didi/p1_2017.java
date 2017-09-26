package com.zhenti.didi;

import java.util.Scanner;

/**
 * Created by BIG-JIAN on 2017/8/26.
 * https://www.nowcoder.com/test/question/5a304c109a544aef9b583dce23f5f5db?pid=3701760&tid=10296138
 * 连续最大和
 */
public class p1_2017 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int max = Integer.MIN_VALUE;
        int tmp = 0;
        for (int i = 0; i < n; i++) {
            tmp += sc.nextInt();
            max = Math.max(max, tmp);
            if (tmp < 0) {
                tmp = 0;
            }
        }
        System.out.println(max);
    }

}
