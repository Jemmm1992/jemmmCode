package com.zhenti.wangyi;

import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.*;

/**
 * https://www.nowcoder.com/questionTerminal/d64d259ee34141378b62e1ea4be74030
 */

public class t3 {
    private static class Node {
        int px, py, bx, by;
        Node pre;

        public Node(int px, int py, int bx, int by, Node pre) {
            this.px = px; // 人
            this.py = py;
            this.bx = bx;
            this.by = by;// 箱
            this.pre = pre;
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        while (sc.hasNext()) {
            String s = sc.nextLine();
            int n = Integer.parseInt(s.split(" ")[0]);
            int px = -1, py = -1, bx = -1, by = -1;
            char[][] maze = new char[n][];
            for (int i = 0; i < n; i++) {
                maze[i] = sc.nextLine().toCharArray();
                for (int j = 0; j < maze[i].length; j++) {
                    if (maze[i][j] == 'X') {
                        px = i;
                        py = j;
                    } else if (maze[i][j] == '*') {
                        bx = i;
                        by = j;
                    }
                }
            }
            Node start = new Node(px, py, bx, by, null);
            List<Node> list = bfs(maze, start);
            System.out.println(list.size() - 1);
        }
    }

    private static List<Node> bfs(char[][] maze, Node start) {
        int n = maze.length;
        int m = maze[0].length;
        boolean[][][][] added = new boolean[n][m][n][m];
        Queue<Node> queue = new LinkedList<>();
        LinkedList<Node> list = new LinkedList<>();
        queue.add(start);
        added[start.px][start.py][start.bx][start.py] = true;
        int[][] move = {{-1, 0}, {1, 0}, {0, -1}, {0, 1}};
        Node end = null;

        while (!queue.isEmpty()) {
            Node cur = queue.poll();
            if (maze[cur.bx][cur.by] == '@') {
                end = cur;
                break;
            }
            for (int[] a : move) {
                Node next = new Node(cur.px + a[0], cur.py + a[1], cur.bx, cur.by, cur);
                if (next.px == next.bx && next.py == next.by) {
                    next.bx += a[0];
                    next.by += a[1];
                    if (next.bx < 0 || next.bx >= n || next.by < 0 || next.by >= m || maze[next.bx][next.by] == '#')
                        continue;
                } else if (next.px < 0 || next.px >= n || next.py < 0 || next.py >= m || maze[next.px][next.py] == '#') {
                    continue;
                }
                if (!added[next.px][next.py][next.bx][next.by]) {
                    queue.add(next);
                    added[next.px][next.py][next.bx][next.by] = true;
                }
            }
        }
        if (end != null) {
            while (end != null) {
                list.addFirst(end);
                end = end.pre;
            }
        }
        return list;
    }
}