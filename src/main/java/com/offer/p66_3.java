package com.offer;

/**
 * Created by BIG-JIAN on 2017/9/15.
 */
public class p66_3 {
    public static void main(String[] args) {
        char[] matrix = "abcesfcsadee".toCharArray();
        char[] str = "bcced".toCharArray();
        System.out.println(hasPath(matrix, 3, 4, str));
    }

    public static boolean hasPath(char[] matrix, int rows, int cols, char[] str) {
        char[][] c = new char[rows][cols];
        int k = 0;
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                c[i][j] = matrix[k++];
            }
        }
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                if (c[i][j] == str[0]) {
                    boolean[][] b = new boolean[rows][cols];
                    if (bfs(c, rows, cols, i, j, b, 0, str)) return true;
                }
            }
        }
        return false;
    }

    static int[][] d = {{0, 1}, {0, -1}, {1, 0}, {-1, 0}};

    public static boolean bfs(char[][] c, int rows, int cols, int R, int C, boolean[][] b, int level, char[] str) {
        if (level == str.length) return true;
        if (R >= 0 && R < rows && C >= 0 && C < cols && !b[R][C] && str[level] == c[R][C]) {
            b[R][C] = true;
            for (int i = 0; i < 4; i++) {
                if (bfs(c, rows, cols, R + d[i][0],C + d[i][1], b, level + 1, str)) return true;
            }
        }
        return false;
    }

}
