package com.offer;

/**
 * Created by BIG-JIAN on 2017/9/15.
 */
public class p67_3 {
    static int cnt = 0;
    static int[][] d = {{0, 1}, {0, -1}, {1, 0}, {-1, 0}};

    public static void main(String[] args) {
        System.out.println(movingCount(15, 20, 20));
    }

    public static int movingCount(int threshold, int rows, int cols) {
        boolean[][] b = new boolean[rows][cols];
        Integer[] a = new Integer[1];
        a[0] = 0;
        dfs(threshold, rows, cols, 0, 0, b, a);
        return a[0];
    }

    public static void dfs(int threshold, int rows, int cols, int R, int C, boolean[][] b, Integer[] a) {
        for (int i = 0; i < 4; i++) {
            R = R + d[i][0];
            C = C + d[i][1];
            if (R >= 0 && R < rows && C >= 0 && C < cols) {
                if (!b[R][C] && getSum(R) + getSum(C) <= threshold) {
                    b[R][C] = true;
//                    cnt++;
                    a[0]++;
                    dfs(threshold, rows, cols, R, C, b, a);
                }
            }
        }
    }

    public static int getSum(int a) {
        int sum = 0;
        while (a != 0) {
            sum += a % 10;
            a /= 10;
        }
        return sum;
    }
}
