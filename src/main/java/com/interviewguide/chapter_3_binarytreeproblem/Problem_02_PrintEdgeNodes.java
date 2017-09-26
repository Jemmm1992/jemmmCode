package com.interviewguide.chapter_3_binarytreeproblem;

import com.modal.Node;

/**
 * Created by BIG-JIAN on 2017/9/6.
 * 逆时针打印二叉树的边界结点
 */
public class Problem_02_PrintEdgeNodes {
    public static void main(String[] args) {
        Node head = new Node(1);
        head.left = new Node(2);
        head.right = new Node(3);
        head.left.right = new Node(4);
        head.right.left = new Node(5);
        head.right.right = new Node(6);
        head.left.right.left = new Node(7);
        head.left.right.right = new Node(8);
        head.right.left.left = new Node(9);
        head.right.left.right = new Node(10);
        head.left.right.right.right = new Node(11);
        head.right.left.left.left = new Node(12);
        head.left.right.right.right.left = new Node(13);
        head.left.right.right.right.right = new Node(14);
        head.right.left.left.left.left = new Node(15);
        head.right.left.left.left.right = new Node(16);

        printEdge1(head);
    }

    public static void printEdge1(Node head) {
        if (head == null) return;
        int height = getHeight(head, 0);
        Node[][] edgeMap = new Node[height][2];
        setEdgeMap(head, 0, edgeMap);
        // 打印左边界
        for (int i = 0; i < edgeMap.length; i++) {
            System.out.print(edgeMap[i][0].value + " ");
        }
        // 打印既不是左边也不是右边界的叶子结点
        printfLeafNotInMap(head, 0, edgeMap);
        // 打印右边界，但不是左边界的结点
        for (int i = edgeMap.length - 1; i >= 0; i--) {
            if (edgeMap[i][0] != edgeMap[i][1])
                System.out.print(edgeMap[i][1].value + " ");
        }
    }

    private static void setEdgeMap(Node head, int level, Node[][] edgeMap) {
        if (head == null) return;
        edgeMap[level][0] = edgeMap[level][0] == null ? head : edgeMap[level][0];//左边只记录该层的最左边的结点
        edgeMap[level][1] = head;// 右边的值递归中更新，保持该层最右边的结点
        setEdgeMap(head.left, level + 1, edgeMap);
        setEdgeMap(head.right, level + 1, edgeMap);
    }

    private static void printfLeafNotInMap(Node head, int level, Node[][] m) {
        if (head == null) return;
        if (head.left == null && head.right == null && head != m[level][0] && head != m[level][1])
            System.out.print(head.value + " ");
        printfLeafNotInMap(head.left, level + 1, m);
        printfLeafNotInMap(head.right, level + 1, m);
    }

    /**
     * 获取树的高度
     */
    public static int getHeight(Node head, int level) {
        if (head == null) return level;
        return Math.max(getHeight(head.left, level + 1), getHeight(head.right, level + 1));
    }


}
