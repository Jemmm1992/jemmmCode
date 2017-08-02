package com.zhenti.pinduoduo;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

/**
 * Created by BIG-JIAN on 2017/8/1.
 */
public class Main1 {
    static boolean[][] visited;
    static int[][] direction = {{0, 1}, {0, -1}, {1, 0}, {-1, 0}};
    static int m = 0;
    static int n = 0;
    static boolean[] b = new boolean[30];

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        m = sc.nextInt();
        n = sc.nextInt();
        char[][] ch = new char[m][n];
        int ax = 0, ay = 0;
        int Ax = 0, Ay = 0;
        int menx = 0, meny = 0;
        int sx = 0, sy = 0;
        while (sc.hasNext()) {
            visited = new boolean[m][n];
            for (int i = 0; i < m; i++) {
                char[] temp = sc.next().toCharArray();
                for (int j = 0; j < n; j++) {
                    if (temp[j] == '2') {
                        sx = i;
                        sy = j;
                    }
                    if (temp[j] == '3') {
                        menx = i;
                        meny = j;
                    }
                    ch[i][j] = temp[j];
                }
            }
            miNode start = new miNode(sx, sy, 0);
            miNode end = new miNode(menx, meny, 0);
            bfs(ch, start, end);
        }
    }


    private static void bfs(char[][] ch, miNode start, miNode end) {
        Queue<miNode> queue = new LinkedList<>();
        queue.add(start);
        while (!queue.isEmpty()) {
            miNode cur = queue.poll();
            if (cur.x == end.x && cur.y == end.y) {
                System.out.println(cur.step);
                break;
            }
            for (int i = 0; i < 4; i++) {
                miNode next = new miNode(cur.x + direction[i][0], cur.y + direction[i][1], cur.step + 1);
                if (next.x >= 0 && next.x < m && next.y + direction[i][1] >= 0 &&
                        next.y + direction[i][1] < n && ch[next.x][next.y] != '0' && !visited[next.x][next.y]) {
                    if (ch[next.x][next.y] == '1' || (ch[next.x][next.y] >= 'a' && ch[next.x][next.y] <= 'z')
                            || ((ch[next.x][next.y] >= 'A' && ch[next.x][next.y] <= 'Z') && b[ch[next.x][next.y] - 'A'] == true)) {
                        queue.add(next);
                        visited[next.x][next.y] = true;
                        if (((ch[next.x][next.y] >= 'A' && ch[next.x][next.y] <= 'Z') && b[ch[next.x][next.y] - 'A'] != true)) {
                            b[ch[next.x][next.y] - 'a'] = true;
                        }
                    }
                }
            }
        }
    }

    static class miNode {
        int x, y, step;

        public miNode(int x, int y, int step) {
            this.x = x;
            this.y = y;
            this.step = step;
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
//01101
//01003
//01001
//01111