package com.zhenti.wangyi.qiuzhao2017;

import java.util.Arrays;
import java.util.Scanner;

import static com.utils.PrintfUtils.printf;

/**
 * Created by BIG-JIAN on 2017/8/12.
 */
public class p6_maxjishu {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
//        int a = sc.nextInt();
        get1(7);
    }


    public static void get1(int x) {
        int m = (int) Math.sqrt(x);
        int[] data = new int[x];
        Arrays.fill(data, 1);

        for (int j = 2; j < m; j++) {
            if (data[j] == 1) {
                for (int k = 2 * j; k < x; k += j) {
                    data[k] = j;
                }
            }
        }
        printf(data);
    }

}
//    public static int getYue(int n) {
//        for (int i = 1; i <= Math.sqrt(n); i++) {
//            if (n % i == 0 && ((n / i) % 2 == 1)) {
//                return n / i;
//            }
//        }
//        return 1;
//    }