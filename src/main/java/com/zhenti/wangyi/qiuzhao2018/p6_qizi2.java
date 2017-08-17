package com.zhenti.wangyi.qiuzhao2018;

import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.Scanner;

/**
 * Created by BIG-JIAN on 2017/8/13.
 * 网易2017年内推校招 [编程题]堆棋子
 */
public class p6_qizi2 {
    /*
     * 暴力解法 该解法为 @蟹粉馅大糖包 首创
     * 思路：最后关键的棋子的横坐标和纵坐标肯定是出现过的横坐标和纵坐标
     * 举个栗子：输入为
     *  4
     *  1 2 4 9
     *  1 1 1 1
     *
     * 那么最后关键棋子的横坐标必然是1,2,4,9中的一个，纵坐标必然是1
     *
     *
     * 证明可以参考@蟹粉馅大糖包 的反证法，如下：
     *  xy轴其实是独立的，先只考虑x坐标，假设把k个棋子堆到x0格子所用的步骤最少，
     * a个棋子初始在x0的左边，b个棋子初始在x0的右边，且a>b,那么必然存在横坐标为x0-1的格子，
     * 这k个棋子到x0-1的步数会更少，b>a的情况，那么x0+1的目标将比x0更优，
     * 至于a=b，x0-1 和x0的步数是一样的。
     * 因此，最终汇聚棋子的x坐标只要在棋子初始的x个坐标中考虑
     */
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] x = new int[n];
        int[] y = new int[n];
        for (int i = 0; i < n; i++)
            x[i] = sc.nextInt();
        for (int i = 0; i < n; i++)
            y[i] = sc.nextInt();
        sc.close();
        StringBuilder sb = new StringBuilder();
        sb.append(0);
        for (int k = 2; k <= n; k++) {
            int sum = Integer.MAX_VALUE;
            for (int i = 0; i < n; i++) {
                for (int j = 0; j < n; j++) {
                    int tmpSum = 0;
                    PriorityQueue<Integer> heap = new PriorityQueue<>(k, new Comparator<Integer>() {
                        @Override
                        public int compare(Integer o1, Integer o2) {
                            return o2 - o1;
                        }
                    });
                    for (int a = 0; a < n; a++) {
                        int distance = Math.abs(x[a] - x[i]) + Math.abs(y[a] - y[j]);
                        tmpSum += distance;

                        heap.add(distance);
                        if (heap.size() > k) {
                            tmpSum -= heap.poll();
                        }
                    }
                    sum = Math.min(sum, tmpSum);
                }
            }
            sb.append(" " + sum);
        }
        System.out.println(sb.toString());
    }
}
