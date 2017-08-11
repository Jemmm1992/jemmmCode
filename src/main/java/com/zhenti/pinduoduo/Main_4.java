package com.zhenti.pinduoduo;

import java.util.*;

/**
 * Created by BIG-JIAN on 2017/8/5.
 */
public class Main_4 {
    static int bx = 0, by = 0, ex = 0, ey = 0;
    static int m, n;


    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        m = sc.nextInt();
        n = sc.nextInt();
        char[][] mz = new char[m][n];
        for (int i = 0; i < m; i++) {
            char[] c = sc.next().toCharArray();
            for (int j = 0; j < n; j++) {
                if (c[j] == '2') {
                    bx = i;
                    by = j;
                }
                if (c[j] == '3') {
                    ex = i;
                    ey = j;
                }
                mz[i][j] = c[j];
            }
        }
        boolean[][] v = new boolean[m][n];
        Node start = new Node(bx, by, 0, 0);
        Node end = new Node(ex, ey, 0, 0);
        bfs(start, end, mz);

    }

    private static void bfs(Node start, Node end, char[][] mz) {
        HashMap<Integer, Integer> key = new HashMap<>();
        int k = 1;
        Queue<Node> q = new LinkedList<>();
        boolean[][][] vis = new boolean[m][n][1100];
        q.add(start);
        vis[start.x][start.y][0] = true;
        int[][] d = {{0, 1}, {0, -1}, {1, 0}, {-1, 0}};
        while (!q.isEmpty()) {
            Node p = q.poll();
            if (p.x == end.x && p.y == end.y) {
                System.out.println(p.step);
                break;
            }

            for (int i = 0; i < 4; i++) {
                Node no = new Node(p.x + d[i][0], p.y + d[i][1], p.step + 1, p.sta);
                if (no.x >= 0 && no.x < m && no.x >= 0 && no.y < n && !vis[no.x][no.y][no.sta] && mz[no.x][no.y] != '0') {
                    char c = mz[no.x][no.y];
                    if (c >= 'a' && c <= 'z') {
                        if (key.get((int) c) == null) {
                            key.put((int) c, k++);
                        }
                        no.sta |= 1 << key.get((int) c);
                        vis[no.x][no.y][no.sta] = true;
                        q.offer(no);
                    } else if (c >= 'A' && c <= 'Z' && key.get(c - 'A' + 'a') != null) {
                        int i1 = 1 << (key.get(c - 'A' + 'a'));
                        if ((no.sta & i1) != 0) {
                            vis[no.x][no.y][no.sta] = true;
                            q.offer(no);
                        }
                    } else if (c == '1' || c == '3') {
                        vis[no.x][no.y][no.sta] = true;
                        q.offer(no);
                    }
                }
            }

        }
    }

    static class Node {
        int x;
        int y;
        int step;
        int sta;

        public Node(int x, int y, int step, int sta) {
            this.x = x;
            this.y = y;
            this.step = step;
            this.sta = sta;
        }
    }
}

//5 5
//02111
//01a0A
//01003
//01001
//01111

//5 5
//02111
//01001
//01003
//01001
//01111

//5 5
//0211B
//01a0A
//0b003
//0100A
//01111

//5 5
//02Ca1
//0110A
//01003
//0c00D
//01111