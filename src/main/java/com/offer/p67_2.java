package com.offer;

/**
 * Created by BIG-JIAN on 2017/8/21.
 * 机器人的运动范围
 * 地上有一个m行和n列的方格。一个机器人从坐标0,0的格子开始移动，每一次只能向左，右，上，下四个方向移动一格，
 * 但是不能进入行坐标和列坐标的数位之和大于k的格子。 例如，当k为18时，机器人能够进入方格（35,37），因为3+5+3+7 = 18。
 * 但是，它不能进入方格（35,38），因为3+5+3+8 = 19。请问该机器人能够达到多少个格子？
 */
public class p67_2 {
    static int[][] d = {{0, 1}, {0, -1}, {1, 0}, {-1, 0}};

    public static int movingCount(int k, int m, int n) {
        boolean[][] b = new boolean[m][n];
        int bfs = bfs(k, m, n, 0, 0, b);
        return bfs;
    }

    public static int bfs(int k, int m, int n, int i, int j, boolean[][] b) {
        int count = 0;
        if (check(k, m, n, i, j, b)) {
            b[i][j] = true;
            count++;
            for (int v = 0; v < 4; v++) {
                i = i + d[v][0];
                j = j + d[v][1];
                count += bfs(k, m, n, i, j, b);
            }
        }
        return count;
    }

    private static boolean check(int k, int m, int n,
                                 int i, int j, boolean[][] visited) {
        return j >= 0 && j < n
                && i >= 0 && i < m
                && !visited[i][j]
                && (getSum(i, j) <= k);
    }

    public static int getSum(int m, int n) {
        int sum = 0;
        while (m > 0) {
            sum += m % 10;
            m /= 10;
        }
        while (n > 0) {
            sum += n % 10;
            n /= 10;
        }
        return sum;
    }

    public static void main(String[] args) {
        System.out.println(movingCount(15, 20, 20));
    }
}
