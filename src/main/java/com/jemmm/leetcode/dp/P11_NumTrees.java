package com.jemmm.leetcode.dp;

/**
 * Created by BIG-JIAN on 2017/7/29.
 */
public class P11_NumTrees {
    /**
     * 使用了卡特兰公式
     * c(n,2n)/(n+1) = (2n)!/(n!*(n+1)!)
     */
    public static int numTrees(int n) {
        long res = 1;
        for (int i = n + 1; i <= 2 * n; i++) {
            res = res * i / (i - n);
        }
        return (int) (res / (n + 1));
    }

    /**
     * 对于任意以i为根节点的二叉树，
     * 它的左子树的值一定小于i，也就是[0, i - 1]区间，而右子树的值一定大于i，也就是[i + 1, n]。假设左子树有
     * m种排列方式，而右子树有n种，则对于i为根节点的二叉树总的排列方式就是m x n。
     * 我们使用dp[i]表示i个节点下面二叉树的排列个数，那么dp方程为:
     * dp[i] = sum(dp[k] * dp[i - k -1]) 0
     */
    public static int numTrees2(int n) {
        int[] dp = new int[n + 1];
        dp[0] = 1;
        dp[1] = 1;
        for (int i = 2; i <= n; i++) {
            for (int j = 0; j <= i; j++) {
                //如果左子树的个数为j，那么右子树为i - j - 1
                dp[i] += dp[j] * dp[i - j - 1];
            }
        }
        return dp[n];
    }


    public static void main(String[] args) {
        System.out.println(numTrees(19));
    }

}
