package com.prototype.graph;

/**
 * Created by BIG-JIAN on 2017/9/17.
 */
public class Graph {
    final int max = 100;

    /*
     * 顶点节点
     */
    public class VexNode {
        int adjvex;
        int data;
    }

    VexNode[] vexNodes;
    int[] thevexs; //顶点集合
    int[][] edges = new int[max][max]; //边集ggfgrt4er合


    /*
     * 创建图
     */
    public void createGraph(Graph graph, int[][] A, int[] vexs) {
        thevexs = vexs;
        for (int i = 0; i < vexs.length; i++) {
            for (int j = 0; j < vexs.length; j++) {
                graph.edges[i][j] = A[i][j];
            }
        }
    }

    /*
     * 输出图
     */
    public void printGraph(Graph graph) {
        for (int i = 0; i < graph.thevexs.length; i++) {
            for (int j = 0; j < graph.thevexs.length; j++) {
                //没有路径则输出/
                if (graph.edges[i][j] == 1000) System.out.printf("%4s", "/");
                else System.out.printf("%4d", graph.edges[i][j]);
            }
            System.out.println("\n");
        }
    }

}