package com.prototype.maze;

import java.util.Iterator;
import java.util.LinkedList;
import java.util.Scanner;

/**
 * Created by xu_zj on 2017/8/2.
 * https://www.nowcoder.com/questionTerminal/571cfbe764824f03b5c0bfd2eb0a8ddf
 */

public class Maze2 {
    private static int m = 0, n = 0, minCost = Integer.MAX_VALUE, p = 0;
    private static LinkedList<Node> linkedList = new LinkedList<>();
    private static String path = "";

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        n = in.nextInt();
        m = in.nextInt();
        p = in.nextInt();
        int[][] map = new int[n][m];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                map[i][j] = in.nextInt();
            }
        }
        dfs(map, 0, 0, 0);
        if (minCost == Integer.MAX_VALUE) {
            System.out.println("Can not escape!");
        } else {
            System.out.println(path.substring(0, path.length() - 1));
        }
    }

    private static void dfs(int[][] map, int x, int y, int currentCost) {
        if (currentCost > p) return;
        map[x][y] = 2;// 因为只有0 和1 ，所以等于2变成已经遍历过了
        linkedList.offer(new Node(x, y));
        if (x == 0 && y == m - 1) {
            if (currentCost < minCost) {
                minCost = currentCost;
                savePath();
            }
            map[x][y] = 1;
            linkedList.removeLast();
            return;
        }
        if (x < n - 1 && map[x + 1][y] == 1) {//down
            dfs(map, x + 1, y, currentCost);
        }
        if (x > 0 && map[x - 1][y] == 1) {//up
            dfs(map, x - 1, y, currentCost + 3);
        }
        if (y < m - 1 && map[x][y + 1] == 1) {//right
            dfs(map, x, y + 1, currentCost + 1);
        }
        if (y > 0 && map[x][y - 1] == 1) {//left
            dfs(map, x, y - 1, currentCost + 1);
        }
        map[x][y] = 1;
        linkedList.removeLast();
    }

    private static void savePath() {
        Iterator<Node> iterator = linkedList.iterator();
        StringBuilder sb = new StringBuilder();
        while (iterator.hasNext()) {
            Node point = iterator.next();
            sb.append("[").append(point.x).append(",").append(point.y).append("],");
        }
        path = sb.toString();
    }

    private static class Node {
        int x = 0;
        int y = 0;

        Node(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }
}
