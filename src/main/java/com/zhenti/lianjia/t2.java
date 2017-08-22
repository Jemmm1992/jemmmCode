package com.zhenti.lianjia;

import java.util.Arrays;
import java.util.Scanner;

/**
 * Created by BIG-JIAN on 2017/8/19.
 */
public class t2 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] aSum = new int[n];
        for (int i = 0; i < n; i++) {
            int tmp = sc.nextInt();
            aSum[i] = i > 0 ? aSum[i - 1] + tmp : tmp;
        }
        int qn = sc.nextInt();
        for (int i = 0; i < qn; i++) {
            int i1 = Arrays.binarySearch(aSum, sc.nextInt());
            if (i1 < 0) System.out.println(-i1);
            else System.out.println(i1 + 1);
        }
    }
}
//5
//2 7 3 4 9
//3
//1 25 11

