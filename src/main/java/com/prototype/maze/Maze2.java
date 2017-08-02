package com.prototype.maze;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

/**
 * Created by xu_zj on 2017/8/2.
 * https://www.nowcoder.com/questionTerminal/571cfbe764824f03b5c0bfd2eb0a8ddf
 */
public class Maze2 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int m = sc.nextInt();
        int p = sc.nextInt();
        int[][] a = new int[n][m];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                a[i][j] = sc.nextInt();
            }
        }
        Node start = new Node(0, 0, 0);
        Node end = new Node(0, m - 1, 0);
        dfs(start, end, a, p);
    }

    public static void dfs(Node start, Node end, int[][] a, int p) {
        boolean[][] b = new boolean[a.length][a[0].length];
        int[][] d = {{1, 0}, {-1, 0}, {0, 1}, {0, -1}};
        Queue<Node> q = new LinkedList<>();
        q.offer(start);

        while (!q.isEmpty()) {
            Node cur = q.poll();
            if (cur.x == end.x && cur.y == end.y) {

            }
        }

    }

    static class Node {
        int x;
        int y;
        int step;

        public Node(int x, int y, int step) {
            this.x = x;
            this.y = y;
            this.step = step;
        }

        @Override
        public String toString() {
            return "[" + x + "," + y + "]";
        }
    }
}
