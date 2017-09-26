package com.prototype.graph;

/**
 * Created by BIG-JIAN on 2017/9/17.
 */
public class Floyd {
    final int max = 100;
    final int INF = 1000;

    public void DispAllPath(Graph graph, int[][] A, int[][] path) {
        int i, j, k, s, d;
        int[] apath = new int[max];
        for (i = 0; i < graph.thevexs.length; i++) {
            for (j = 0; j < graph.thevexs.length; j++) {
                if (A[i][j] != INF && i != j) {
                    System.out.printf("顶点%d到%d最短路径长度为：%d\t路径：", i, j, A[i][j]);
                    k = path[i][j];
                    d = 0;
                    apath[d] = j;
                    while (k != -1 && k != i) {
                        d++;
                        apath[d] = k;
                        k = path[i][k];
                    }
                    d++;
                    apath[d] = i;
                    System.out.printf("%d", apath[d]);
                    for (s = d - 1; s >= 0; s--) {
                        System.out.printf("->%d", apath[s]);
                    }
                    System.out.println("\n");
                }
            }
        }

    }


    public void Dispdispath(int[][] A, int[][] path, int n, int k) {
        int i, j;
        System.out.printf("\tA[%d]\t\t\t\tpath[%d]\n", k, k);
        for (i = 0; i < n; i++) {
            for (j = 0; j < n; j++) {
                if (A[i][j] == INF) {
                    System.out.printf("%4s", "*");
                } else {
                    System.out.printf("%4d", A[i][j]);
                }
            }

            for (j = 0; j < n; j++) {
                System.out.printf("%4d", path[i][j]);
            }
            System.out.println("\n");
        }


    }

    public Floyd(Graph graph) {
        int[][] A = new int[max][max];
        int[][] path = new int[max][max];
        int i, j, k;
        for (i = 0; i < graph.thevexs.length; i++) {
            for (j = 0; j < graph.thevexs.length; j++) {
                A[i][j] = graph.edges[i][j];
                if (i != j && graph.edges[i][j] < INF) {
                    path[i][j] = i;
                } else {
                    path[i][j] = -1;
                }
            }
        }
        Dispdispath(A, path, graph.thevexs.length, -1);

        for (k = 0; k < graph.thevexs.length; k++) {
            for (i = 0; i < graph.thevexs.length; i++) {
                for (j = 0; j < graph.thevexs.length; j++) {
                    if (A[i][j] > A[i][k] + A[k][j]) {
                        A[i][j] = A[i][k] + A[k][j];
                        path[i][j] = path[k][j];
                    }
                }
            }
            Dispdispath(A, path, graph.thevexs.length, k);
        }
        DispAllPath(graph, A, path);

    }
}
