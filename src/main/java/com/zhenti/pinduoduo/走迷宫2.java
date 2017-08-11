package com.zhenti.pinduoduo;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

/**
 * Created by BIG-JIAN on 2017/8/1.
 */
public class 走迷宫2 {
    static int m = 0;
    static int n = 0;
    static int[][] direction = {{0, 1}, {0, -1}, {1, 0}, {-1, 0}};

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        m = sc.nextInt();
        n = sc.nextInt();
        int bx = 0, by = 0, ex = 0, ey = 0;
        while (sc.hasNext()) {
            char[][] map = new char[m][n];
            for (int i = 0; i < m; i++) {
                String s = sc.next();
                for (int j = 0; j < n; j++) {
                    map[i][j] = s.charAt(j);
                    if (s.charAt(j) == '2') {
                        bx = i;
                        by = j;
                    }
                    if (s.charAt(j) == '3') {
                        ex = i;
                        ey = j;
                    }
                }
            }
            boolean[] b = new boolean[26];
            Node start = new Node(bx, by, 0, b);
            Node end = new Node(ex, ey, 0, b);
            bfs(map, direction, start, end);
        }
    }

    public static void bfs(char[][] map, int[][] direction, Node start, Node end) {
        boolean[][] visited = new boolean[m][n];
        Queue<Node> queue = new LinkedList<>();
        queue.add(start);
        visited[start.x][start.y] = true;

        while (!queue.isEmpty()) {
            Node cur = queue.poll();
            if (cur.x == end.x && cur.y == end.y) {
                System.out.println(cur.step);
                break;
            }

            for (int i = 0; i < 4; i++) {
                Node next = new Node(cur.x + direction[i][0], cur.y + direction[i][1], cur.step + 1, cur.b.clone());
                if (next.x >= 0 && next.x < map.length && next.y >= 0 && next.y < map[0].length
                        && !visited[next.x][next.y] && map[next.x][next.y] != '0') {
                    char c = map[next.x][next.y];
                    if (c >= 'a' && c <= 'z') {
                        System.out.println("xxx1");
                        next.b[c - 'a'] = true;
                        queue.add(next);
                        visited[next.x][next.y] = true;
                    } else if (c >= 'A' && c <= 'Z') {
                        if (next.b[c - 'A']) {
                            System.out.println("xxx2");
                            queue.add(next);
                            visited[next.x][next.y] = true;
                        }
                    } else {
                        queue.add(next);
                        visited[next.x][next.y] = true;
                    }
                }
            }
        }
    }

    static class Node {
        int x;
        int y;
        int step;
        boolean[] b;

        public Node(int x, int y, int step, boolean[] b) {
            this.x = x;
            this.y = y;
            this.step = step;
            this.b = b;
        }
    }
}
//5 5
//02111
//01101
//01003
//01001
//01111

//5 5
//02111
//01a0A
//01003
//01001
//01111