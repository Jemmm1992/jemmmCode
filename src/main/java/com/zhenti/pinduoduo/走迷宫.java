package com.zhenti.pinduoduo;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

/**
 * Created by BIG-JIAN on 2017/8/1.
 * NowCoder最喜欢游乐场的迷宫游戏，他和小伙伴们比赛谁先走出迷宫。
 * 现在把迷宫的地图给你，你能帮他算出最快走出迷宫需要多少步吗？
 * 输入描述:
 * 输入包含多组数据。
 * 每组数据包含一个10*10，由“#”和“.”组成的迷宫。其中“#”代表墙；“.”代表通路。
 * 入口在第一行第二列；出口在最后一行第九列。
 * 从任意一个“.”点都能一步走到上下左右四个方向的“.”点。
 * 输出描述:
 * 对应每组数据，输出从入口到出口最短需要几步。
 */
public class 走迷宫 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        while (sc.hasNextLine()) {
            Character[][] map = new Character[10][10];
            for (int i = 0; i < 10; i++) {
                String s = sc.nextLine();
                for (int j = 0; j < 10; j++) {
                    map[i][j] = s.charAt(j);
                }
            }
            int[][] direction = {{0, 1}, {0, -1}, {1, 0}, {-1, 0}};
            Node start = new Node(0, 1, 0);
            Node end = new Node(9, 8, 0);
            bfs(map, direction, start, end);
        }
    }

    public static void bfs(Character[][] map, int[][] direction, Node start, Node end) {
        boolean[][] visited = new boolean[map.length][map[0].length];
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
                Node next = new Node(cur.x + direction[i][0], cur.y + direction[i][1], cur.step + 1);
                if (next.x >= 0 && next.x < map.length && next.y >= 0 && next.y < map[0].length
                        && !visited[next.x][next.y] && map[next.x][next.y] != '#') {
                    queue.add(next);
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
//        #.########
//        #........#
//        #........#
//        #........#
//        #........#
//        #........#
//        #........#
//        #........#
//        #........#
//        ########.#
//        #.########
//        #........#
//        ########.#
//        #........#
//        #.########
//        #........#
//        ########.#
//        #........#
//        #.######.#
//        ########.#