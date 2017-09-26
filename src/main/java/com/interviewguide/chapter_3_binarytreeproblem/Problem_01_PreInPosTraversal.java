package com.interviewguide.chapter_3_binarytreeproblem;

import com.modal.Node;

import java.util.Stack;

/**
 * Created by BIG-JIAN on 2017/9/6.
 * 非递归的方法
 */
public class Problem_01_PreInPosTraversal {
    public static void main(String[] args) {
        Node head = new Node(5);
        head.left = new Node(3);
        head.right = new Node(8);
        head.left.left = new Node(2);
        head.left.right = new Node(4);
        head.left.left.left = new Node(1);
        head.right.left = new Node(7);
        head.right.left.left = new Node(6);
        head.right.right = new Node(10);
        head.right.right.left = new Node(9);
        head.right.right.right = new Node(11);

        preOrderUnRecur(head); // 先序遍历
        inOrderUnRecur(head); // 中序遍历
        posOrderUnRecur(head); // 后序遍历

    }

    public static void posOrderUnRecur(Node head) {
        System.out.print("pos-order: ");
        if (head != null) {
            Stack<Node> s1 = new Stack<>();
            Stack<Node> s2 = new Stack<>();
            s1.push(head);
            while (!s1.isEmpty()) {
                head = s1.pop();
                s2.push(head);
                if (head.left != null) s1.push(head.left);
                if (head.right != null) s1.push(head.right);
            }

            while (!s2.isEmpty()) {
                System.out.print(s2.pop().value + " ");
            }
        }
    }

    public static void inOrderUnRecur(Node head) {
        System.out.print("pos-order: ");
        if (head != null) {
            Stack<Node> stack = new Stack<>();
            while (!stack.isEmpty() || head != null) {
                if (head != null) {
                    stack.push(head);
                    head = head.left;
                } else {
                    head = stack.pop();
                    System.out.print(head.value + " ");
                    head = head.right;
                }
            }
        }
        System.out.println();
    }

    public static void preOrderUnRecur(Node head) {
        System.out.print("pre-order: ");
        if (head != null) {
            Stack<Node> stack = new Stack<>();
            stack.add(head);
            while (!stack.isEmpty()) {
                head = stack.pop();
                System.out.print(head.value + " ");
                if (head.right != null) stack.push(head.right);
                if (head.left != null) stack.push(head.left);
            }
        }
        System.out.println();
    }
}
