package com.prototype.tree;

import com.modal.TreeNode;

import java.util.LinkedList;
import java.util.Queue;

/**
 * Created by BIG-JIAN on 2017/7/31.
 * 二叉树的序列化和反序列化
 */
public class SerialAndRecon {
    public static void main(String[] args) {
        String s = "12!3!#!#!#!";
        TreeNode head = reconByPreString(s);
        PrintfTree.printTree(head);
        String s1 = serialByPre(head);
        System.out.println(s1);
    }

    /**
     * 先序遍历序列化
     */
    public static String serialByPre(TreeNode head) {
        if (head == null) return "#!";
        StringBuffer res = new StringBuffer(head.val + "!");
        res.append(serialByPre(head.left));
        res.append(serialByPre(head.right));
        return res.toString();
    }

    /**
     * 将序列化后的字符串重构成二叉树
     */
    public static TreeNode reconByPreString(String preStr) {
        String[] values = preStr.split("!");
        Queue<String> queue = new LinkedList<String>();
        for (int i = 0; i != values.length; i++) {
            queue.offer(values[i]);
        }
        return reconPreOrder(queue);
    }

    private static TreeNode reconPreOrder(Queue<String> queue) {
        String value = queue.poll();
        if (value.equals("#")) {
            return null;
        }
        TreeNode head = new TreeNode(Integer.valueOf(value));
        head.left = reconPreOrder(queue);
        head.right = reconPreOrder(queue);
        return head;
    }
}
