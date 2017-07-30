package com.leetcode.other;

import com.leetcode.common.TreeNode;

import java.util.LinkedList;

/**
 * Created by BIG-JIAN on 2017/7/27.
 */
public class p14_MaxDepth {
    static int max = 0;

    //采用DFS的思想
    public int maxDepth(TreeNode root) {
        if (null == root) return 0;
        return Math.max(maxDepth(root.left), maxDepth(root.right)) + 1;
    }


    //采用BFS的方法，引入队列
    public int maxDepth2(TreeNode root) {
        if (root == null)
            return 0;
        int level = 0;
        LinkedList<TreeNode> queue = new LinkedList<>();
        queue.add(root);
        int curNum = 1; //num of nodes left in current level
        int nextNum = 0; //num of nodes in next level
        while (!queue.isEmpty()) {
            TreeNode n = queue.poll();
            curNum--;
            if (n.left != null) {
                queue.add(n.left);
                nextNum++;
            }
            if (n.right != null) {
                queue.add(n.right);
                nextNum++;
            }
            if (curNum == 0) {
                curNum = nextNum;
                nextNum = 0;
                level++;
            }
        }
        return level;
    }


//    public static void travel(TreeNode node, int level) {
//        if (node.left == null && node.right == null) {
//            max = Math.max(max, level);
//            return;
//        }
//        if (node.left != null) {
//            travel(node.left, level + 1);
//        }
//        if (node.right != null) {
//            travel(node.right, level + 1);
//        }
//    }
}
