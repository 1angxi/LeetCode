package com.me.tree;

import java.util.*;

/**
 * 给定一个二叉树，返回其节点值的锯齿形层序遍历。（即先从左往右，再从右往左进行下一层遍历，以此类推，层与层之间交替进行）。
 *
 * 例如：
 * 给定二叉树 [3,9,20,null,null,15,7],
 *
 *     3
 *    / \
 *   9  20
 *     /  \
 *    15   7
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/binary-tree-zigzag-level-order-traversal
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class BinaryTreeZigzagLevelOrderTraversal {

    /**
     * 诀窍是使用两个栈。模拟广度优先搜索
     */
    public List<List<Integer>> zigzagLevelOrder(TreeNode root) {

        if (root == null) {
            return new ArrayList<>();
        }

        Deque<TreeNode> stack1 = new LinkedList<>();
        Deque<TreeNode> stack2 = new LinkedList<>();

        List<List<Integer>> list = new ArrayList<>();
        int vert = 0;
        stack1.push(root);
        while (!stack1.isEmpty() || !stack2.isEmpty()) {
            List<Integer> value = new ArrayList<>();

            if (vert == 0) {
                int size = stack1.size();
                for (int i = 0; i < size; i++) {
                    TreeNode treeNode = stack1.pop();
                    if (treeNode.left != null) {
                        stack2.push(treeNode.left);
                    }
                    if (treeNode.right != null) {
                        stack2.push(treeNode.right);
                    }
                    value.add(treeNode.val);
                }
                vert = 1;
            } else {
                int size = stack2.size();
                for (int i = 0; i < size; i++) {
                    TreeNode treeNode = stack2.pop();
                    if (treeNode.right != null) {
                        stack1.push(treeNode.right);
                    }
                    if (treeNode.left != null) {
                        stack1.push(treeNode.left);
                    }
                    value.add(treeNode.val);
                }
                vert = 0;
            }
            list.add(value);
        }
        return list;
    }
}
