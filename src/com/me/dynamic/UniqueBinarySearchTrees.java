package com.me.dynamic;

/**
 * 给你一个整数 n ，求恰由 n 个节点组成且节点值从 1 到 n 互不相同的 二叉搜索树 有多少种？返回满足题意的二叉搜索树的种数。
 * <p>
 *  
 * <p>
 * 示例 1：
 * <p>
 * <p>
 * 输入：n = 3
 * 输出：5
 * 示例 2：
 * <p>
 * 输入：n = 1
 * 输出：1
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/unique-binary-search-trees
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class UniqueBinarySearchTrees {
    public int numTrees(int n) {

        /*
         * 诀窍是动态规划；
         * 可以定义两个函数：
         * 1.G(n): 长度为 nn 的序列能构成的不同二叉搜索树的个数。
         * 2.F(i,n): 以 ii 为根、序列长度为 nn 的不同二叉搜索树个数 (1≤i≤n)。
         *
         * 举例而言，创建以 33 为根、长度为 77 的不同二叉搜索树，整个序列是 [1, 2, 3, 4, 5, 6, 7][1,2,3,4,5,6,7]，我们需要从左子序列 [1, 2][1,2] 构建左子树，从右子序列 [4, 5, 6, 7][4,5,6,7] 构建右子树，然后将它们组合（即笛卡尔积）。
         *
         * G(n)=G(i−1)⋅G(n−i) [i=1-n]
         *
         * 两重循环求到每个G(n)即可得到解。
         *
         */
        int[] G = new int[n + 1];
        G[0] = 0;
        G[1] = 0;
        for (int i = 2; i <= n; i++) {
            for (int j = 1; j <= i; j++) {
                G[i] += G[j - 1] + G[i - j];
            }
        }
        return G[n];
    }
}
