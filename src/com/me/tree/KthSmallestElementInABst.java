package com.me.tree;

import java.util.ArrayList;
import java.util.List;

/**
 * 给定一个二叉搜索树的根节点 root ，和一个整数 k ，请你设计一个算法查找其中第 k 个最小元素（从 1 开始计数）。
 *
 * 示例 1：
 *
 *
 * 输入：root = [3,1,4,null,2], k = 1
 * 输出：1
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/kth-smallest-element-in-a-bst
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class KthSmallestElementInABst {
    public int kthSmallest(TreeNode root, int k) {
        List<TreeNode> nodes = new ArrayList<>();
        findK(root, nodes, k);
        return nodes.get(k - 1).val;
    }


    public void findK(TreeNode root, List<TreeNode> nodes, int k) {
        if (root == null || nodes.size() == k) {
            return;
        }

        findK(root.left, nodes, k);
        nodes.add(root);
        findK(root.right, nodes, k);
    }

}
