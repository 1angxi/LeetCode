package com.me.tree;

import java.util.ArrayList;
import java.util.Deque;
import java.util.LinkedList;
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
public class KthSmallestElementInABstV2 {
    public int kthSmallest(TreeNode root, int k) {
        List<Integer> nodes = new ArrayList<>();
        Deque<TreeNode> stack = new LinkedList<>();

        while (nodes.size() < k) {//如果想遍历完成，就 root != null || !stack.isEmpty()
            while (root != null) {
                stack.push(root);
                root = root.left;
            }
            root = stack.pop();
            nodes.add(root.val);
            root = root.right;
        }

        return nodes.get(k-1);
    }

}
