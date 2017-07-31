package com.leetcode.other;

import com.modal.TreeNode;

import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;

/**
 * Created by BIG-JIAN on 2017/7/27.
 */
public class P18_levelOrder {

    public List<List<Integer>> levelOrder(TreeNode root) {
        List<List<Integer>> res = new ArrayList<>();
        if (root == null)
            return res;
        LinkedList<TreeNode> queue = new LinkedList<>();
        queue.add(root);
        int curNum = 0;
        int lastNum = 1;
        ArrayList<Integer> list = new ArrayList<>();
        while (!queue.isEmpty()) {
            TreeNode cur = queue.poll();
            lastNum--;
            list.add(cur.val);
            if (cur.left != null) {
                queue.add(cur.left);
                curNum++;
            }
            if (cur.right != null) {
                queue.add(cur.right);
                curNum++;
            }
            if (lastNum == 0) {
                lastNum = curNum;
                curNum = 0;
                res.add(list);
                list = new ArrayList<>();
            }
        }
        Collections.reverse(res);
        return res;
    }
}
