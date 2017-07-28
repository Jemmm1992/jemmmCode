package com.jemmm.leetcode.other;

import com.jemmm.leetcode.common.TreeNode;

import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedList;

/**
 * Created by BIG-JIAN on 2017/7/27.
 */
public class P19_levelOrderBottom {
    public ArrayList<ArrayList<Integer>> levelOrderBottom(TreeNode root) {
        ArrayList<ArrayList<Integer>> res = new ArrayList<ArrayList<Integer>>();
        if (root == null)
            return res;
        LinkedList<TreeNode> queue = new LinkedList<TreeNode>();
        int lastNum = 1;
        int curNum = 0;
        int level = 0;
        queue.add(root);
        while (!queue.isEmpty()) {
            TreeNode n = queue.pop();
            if (res.size() <= level)
                res.add(new ArrayList<Integer>());
            res.get(level).add(n.val);
            lastNum--;
            if (n.left != null) {
                queue.add(n.left);
                curNum++;
            }
            if (n.right != null) {
                queue.add(n.right);
                curNum++;
            }
            if (lastNum == 0) {
                level++;
                lastNum = curNum;
                curNum = 0;
            }
        }
        Collections.reverse(res);
        return res;
    }
}
