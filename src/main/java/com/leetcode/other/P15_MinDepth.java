package com.leetcode.other;

import com.leetcode.common.TreeNode;

/**
 * Created by BIG-JIAN on 2017/7/27.
 */
public class P15_MinDepth {
    public int minDepth(TreeNode root) {
        if (root == null) return 0;
        if (root.left == null) return minDepth(root.right) + 1;
        if (root.right == null) return minDepth(root.left) + 1;
        return Math.min(minDepth(root.left), minDepth(root.right)) + 1;
    }
}
