package com.prototype.maze;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

/**
 * Created by xu_zj on 2017/8/2.
 * 题目地址：https://www.nowcoder.com/questionTerminal/6276dbbda7094978b0e9ebb183ba37b9
 * 样例:
 * #.########
 * #........#
 * #........#
 * #........#
 * #........#
 * #........#
 * #........#
 * #........#
 * #........#
 * ########.#
 * 16
 */
public class Maze1 {
    static int[][] d = {{1, 0}, {-1, 0}, {0, 1}, {0, -1}};


    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        char[][] maze = new char[10][10];
        while (sc.hasNextLine()) {
            for (int i = 0; i < 10; i++) {
                String s = sc.nextLine();
                for (int j = 0; j < 10; j++) {
                    maze[i][j] = s.charAt(j);
                }
            }
            Node start = new Node(0, 1, 0);
            Node end = new Node(9, 8, 0);
            bfs(start, end, maze);
        }
    }

    public static void bfs(Node start, Node end, char[][] maze) {
        boolean[][] visited = new boolean[10][10];
        Queue<Node> q = new LinkedList<>();
        q.offer(start);

        while (!q.isEmpty()) {
            Node cur = q.poll();
            if (cur.x == end.x && cur.y == end.y) {
                System.out.println(cur.step);
                break;
            }

            for (int i = 0; i < 4; i++) {
                Node next = new Node(cur.x + d[i][0], cur.y + d[i][1], cur.step + 1);
                if (next.x >= 0 && next.x < 10 && next.y >= 0 && next.y < 10 && !visited[next.x][next.y]
                        && maze[next.x][next.y] != '#') {
                    q.offer(next);
                    visited[next.x][next.y] = true;
                }
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
    }
}
