package com.offer;

/**
 * Created by BIG-JIAN on 2017/8/21.
 */
public class p66_矩阵中的路径 {
    public static void main(String[] args) {
        String s1 = "ABCESFCSADEE";
        String s2 = "SEE";
        System.out.println(hasPath(s1.toCharArray(), 3, 4, s2.toCharArray()));
    }

    public static boolean hasPath(char[] matrix, int m, int n, char[] str) {
        int k = 0;
        char[][] c = new char[m][n];
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                c[i][j] = matrix[k++];
            }
        }

        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (c[i][j] == str[0]) {
                    boolean[][] b = new boolean[m][n];
                    if (bfs(c, m, n, i, j, b, str, 0)) return true;
                }
            }
        }
        return false;
    }

    static int[][] d = {{0, 1}, {1, 0}, {0, -1}, {-1, 0}};

    public static boolean bfs(char[][] c, int m, int n, int i, int j, boolean[][] b, char[] str, int k) {
        if (k == str.length) return true;
        if (j >= 0 && j < n && i >= 0 && i < m && !b[i][j] && c[i][j] == str[k]) {
            b[i][j] = true;
            for (int v = 0; v < 4; v++) {
                if (bfs(c, m, n, i + d[v][0], j + d[v][1], b, str, k + 1)) return true;
            }
        }
        return false;
    }

}
