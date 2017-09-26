package com.zhenti.zhaohangxinyongka;

import java.util.Scanner;

/**
 * Created by BIG-JIAN on 2017/9/13.
 * 题目：一个数组，有m个值，一次可以取1个或者2个，A和B取数，A先取，如果A胜利则输出true，否则false
 * A获得人数的身高就加，B获得人数的身高就减，最后看结果是否大于0。
 */
public class a3 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int m = sc.nextInt();   // 同事数量
        int[] colls = new int[m];// 同事身高数组
        for (int i = 0; i < m; ++i) {
            colls[i] = sc.nextInt();
        }
        int score = winner(colls, 0, 1);
        if (score > 0) {
            System.out.println(true);
        } else {
            System.out.println(false);
        }
        sc.close();
    }

    public static final int winner(int[] nums, int s, int turn) {
        if (s > nums.length - 1) {
            return 0;
        }
        if (s == nums.length - 1) {
            return turn * nums[s];
        }
        int a = turn * (nums[s]) + winner(nums, s + 1, -turn);
        int b = turn * (nums[s] + nums[s + 1]) + winner(nums, s + 2, -turn);
        return turn * Math.max(turn * a, turn * b);
    }
}