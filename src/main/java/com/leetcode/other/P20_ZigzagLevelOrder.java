package com.leetcode.other;

import com.leetcode.common.TreeNode;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

/**
 * Created by BIG-JIAN on 2017/7/27.
 */
public class P20_ZigzagLevelOrder {
    public List<List<Integer>> zigzagLevelOrder(TreeNode root) {
        List<List<Integer>> res = new ArrayList<>();
        if (root == null) return res;
        LinkedList<TreeNode> stack = new LinkedList<>();
        int level = 1;
        ArrayList<Integer> item = new ArrayList<>();
        item.add(root.val);
        res.add(item);
        stack.push(root);
        while (!stack.isEmpty()) {
            LinkedList<TreeNode> newStack = new LinkedList<>();
            item = new ArrayList<>();
            while (!stack.isEmpty()) {
                TreeNode node = stack.pop();
                if (level % 2 == 0) {
                    if (node.left != null) {
                        newStack.push(node.left);
                        item.add(node.left.val);
                    }
                    if (node.right != null) {
                        newStack.push(node.right);
                        item.add(node.right.val);
                    }
                } else {
                    if (node.right != null) {
                        newStack.push(node.right);
                        item.add(node.right.val);
                    }
                    if (node.left != null) {
                        newStack.push(node.left);
                        item.add(node.left.val);
                    }
                }
            }
            level++;
            if (item.size() > 0)
                res.add(item);
            stack = newStack;
        }
        return res;
    }
}
