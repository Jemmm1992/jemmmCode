package com.zhenti.wangyi.qiuzhao2018;

import java.util.Arrays;
import java.util.Scanner;

/**
 * Created by BIG-JIAN on 2017/8/12.
 */

public class p6_qizi {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int[] x = new int[n];
        int[] y = new int[n];
        Node[] nodes = new Node[n];
        for (int i = 0; i < n; i++) {
            nodes[i] = new Node();
            nodes[i].x = scanner.nextInt();
        }
        for (int i = 0; i < n; i++) {
            nodes[i].y = scanner.nextInt();
        }
        for (int i = 0; i < n; i++) {
            print(nodes, i + 1);
        }
    }

    private static void print(Node[] nodes, int cnt) {
        if (cnt == 1) {
            System.out.print("0");
        } else {
            compute(nodes, cnt);
        }
    }

    private static void compute(Node[] nodes, int count) {
        computeDistance(nodes);
        int min = Integer.MAX_VALUE;
        for (int i = 0; i < nodes.length; i++) {
            int temp = 0;
            for (int j = 0; j < count; j++) {
                temp += nodes[i].dis[j];
            }
            min = temp < min ? temp : min;
        }
        System.out.print(" " + min);
    }

    private static void computeDistance(Node[] nodes) {
        for (int i = 0; i < nodes.length; i++) {
            int num = 0;
            nodes[i].dis = new int[nodes.length];
            for (int j = 0; j < nodes.length; j++) {
                nodes[i].dis[num++] = md(nodes[i], nodes[j]);
            }
            nodes[i].sort();
        }
    }

    private static int md(Node a, Node b) {
        return Math.abs(a.x - b.x) + Math.abs(a.y - b.y);
    }

    static class Node {
        int x;
        int y;
        int[] dis;

        public void sort() {
            Arrays.sort(dis);
        }
    }
}