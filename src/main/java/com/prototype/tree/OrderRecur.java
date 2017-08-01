package com.prototype.tree;

import com.modal.TreeNode;

/**
 * Created by BIG-JIAN on 2017/7/31.
 * 二叉树排序递归的实现
 */
public class OrderRecur {
    public static void preOrderRecur(TreeNode head) {
        if (head == null) return;
        System.out.println(head.val + " ");
        preOrderRecur(head.left);
        preOrderRecur(head.right);
    }

    public static void inOrderRecur(TreeNode head) {
        if (head == null) return;
        inOrderRecur(head.left);
        System.out.println(head.val + " ");
        inOrderRecur(head.right);
    }

    public  static void posOrderRecur(TreeNode head) {
        if (head == null) return;
        posOrderRecur(head.left);
        posOrderRecur(head.right);
        System.out.println(head.val + " ");
    }

}
