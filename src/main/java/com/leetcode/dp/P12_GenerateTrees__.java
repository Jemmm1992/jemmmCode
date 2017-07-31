package com.leetcode.dp;

import com.modal.TreeNode;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by BIG-JIAN on 2017/7/29.
 */
public class P12_GenerateTrees__ {
    /**
     * https://leetcode.com/problems/unique-binary-search-trees-ii/description/
     * @param args
     */
    public static void main(String[] args) {
        List<TreeNode> list = generateTrees(3);
    }

    public static List<TreeNode> generateTrees(int n) {
        return helper(1, n);
    }

    /**
     * 解题思路：
     * 这题是 96 Unique Binary Search Trees 的延展，它已经不是让求不同构二叉树的种数，而是直接给出这些不同构的二叉树。
     * 1. 每一次都在一个范围内随机选取一个结点作为根。
     * 2. 每选取一个结点作为根，就把树切分成左右两个子树，直至该结点左右子树为空。
     * <p>
     * 大致思路如上，可以看出这也是一个可以划分成子问题求解的题目，所以考点是动态规划。
     * 但具体对于本题来说，采取的是自底向上的求解过程。
     * 1. 选出根结点后应该先分别求解该根的左右子树集合，也就是根的左子树有若干种，它们组成左子树集合，根的右子树有若干种，它们组成右子树集合。
     * 2. 然后将左右子树相互配对，每一个左子树都与所有右子树匹配，每一个右子树都与所有的左子树匹配。然后将两个子树插在根结点上。
     * 3. 最后，把根结点放入链表中。
     */
    private static List<TreeNode> helper(int left, int right) {
        List<TreeNode> res = new ArrayList<>();
        if (left > right) {
            res.add(null);
            return res;
        }
        for (int i = left; i <= right; i++) {
            List<TreeNode> leftList = helper(left, i - 1);
            List<TreeNode> rightList = helper(i + 1, right);
            for (int j = 0; j < leftList.size(); j++) {
                for (int k = 0; k < rightList.size(); k++) {
                    TreeNode root = new TreeNode(i);
                    root.left = leftList.get(j);
                    root.right = rightList.get(k);
                    res.add(root);
                }
            }
        }
        return res;
    }
}
