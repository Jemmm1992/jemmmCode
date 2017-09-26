package com.leetcode.Backtracking;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by BIG-JIAN on 2017/7/29.
 */
public class P0_NQueens {
    public static void main(String[] args) {
        int n = 4;
        int i = helper2(0, new int[n], n);
        System.out.println(i);

        List<List<String>> lists = solveNQueens(4);
        for (List<String> s : lists) {
            for (String vo : s) {
                System.out.println(vo);
            }
        }
    }

    /**
     * N皇后问题比较经典，一般有两种：1.求N皇后的摆法。2.求N皇后摆法的个数。方法一样。
     */
    public static int helper2(int i, int[] record, int n) {
        if (i == n) return 1;
        int res = 0;
        for (int j = 0; j < n; j++) {
            if (isValid(record, i, j)) {
                record[i] = j;
                res += helper2(i + 1, record, n);
            }
        }
        return res;
    }

    /**
     * 解释：如果在(i,j)上放一个皇后。
     * 要求：1.整个第i行不能放
     * 2.整个第j列不能放
     * 3.如果(a，b)满足|a-i|=|b-j|不能放
     */
    public static boolean isValid(int[] record, int row, int col) {
        for (int i = 0; i < row; i++) {
            if (record[i] == col || Math.abs(record[i] - col) == Math.abs(i - row)) return false;
        }
        return true;
    }


    /**
     * N皇后，求摆法
     */
    public static List<List<String>> solveNQueens(int n) {
        List<List<String>> res = new ArrayList<>();
        helper3(0, new int[n], n, res);
        return res;
    }

    public static void helper3(int row, int[] record, int n, List<List<String>> res) {
        if (row == n) {
            List<String> item = new ArrayList<>();
            for (int i = 0; i < n; i++) {
                StringBuffer sb = new StringBuffer();
                for (int j = 0; j < n; j++) {
                    if (record[i] == j) sb.append("Q");
                    else sb.append(".");
                }
                item.add(sb.toString());
            }
            res.add(item);
            return;
        }
        for (int col = 0; col < n; col++) {
            if (isValid(record, row, col)) {
                record[row] = col;
                helper3(row + 1, record, n, res);
            }
        }
    }

}
