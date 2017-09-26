package com.prototype.graph;

/**
 * Created by BIG-JIAN on 2017/9/17.
 */
public class FloyedTest {
    public static void main(String[] args) {
        final int INF = 1000;
        int[] vexs = {0, 1, 2, 3, 4, 5};
        int[][] A = {
                {0, 50, 10, INF, INF, INF},
                {INF, 0, 15, 50, 10, INF},
                {20, INF, 0, 15, INF, INF},
                {INF, 20, INF, 0, 35, INF},
                {INF, INF, INF, 30, 0, INF},
                {INF, INF, INF, 3, INF, 0},

        };
        Graph graph = new Graph();
        graph.createGraph(graph, A, vexs);
        graph.printGraph(graph);
        Floyd floyd = new Floyd(graph);
    }
}
