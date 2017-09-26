package com.prototype.graph;

/**
 * Created by BIG-JIAN on 2017/9/17.
 */
public class testWeight {
    public static void main(String[] args) {

    }

    public void testWeight() throws Exception {
        GraphByMatrix graph = new GraphByMatrix(true, true, 6);

        graph.addVertex("1");
        graph.addVertex("2");
        graph.addVertex("3");
        graph.addVertex("4");
        graph.addVertex("5");
        graph.addVertex("6");

        graph.addEdge(0, 1, 7);
        graph.addEdge(0, 2, 9);
        graph.addEdge(0, 5, 14);

        graph.addEdge(1, 3, 15);
        graph.addEdge(1, 2, 10);

        graph.addEdge(2, 3, 11);
        graph.addEdge(2, 5, 2);

        graph.addEdge(3, 4, 6);
        graph.addEdge(4, 5, 9);

        graph.Dijkstra(0);
        System.out.println();
        graph.Dijkstra("1");
        System.out.println();
        graph.Dijkstra2(0);
        System.out.println();
    }

}
