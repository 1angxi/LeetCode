package com.me.tree;

import java.util.*;

/**
 * 给定一个二叉树的 根节点 root，想象自己站在它的右侧，按照从顶部到底部的顺序，返回从右侧所能看到的节点值。
 *
 *  
 *
 * 示例 1:
 *
 *
 *
 * 输入: [1,2,3,null,5,null,4]
 * 输出: [1,3,4]
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/binary-tree-right-side-view
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class RightSideView {
    public List<Integer> rightSideView(TreeNode root) {
        Map<Integer, Integer> depthVal = new HashMap<>();
        Queue<TreeNode> nodeQue = new LinkedList<>();
        Queue<Integer> depthQue = new LinkedList<>();
        nodeQue.add(root);
        depthQue.add(0);

        while (!nodeQue.isEmpty()) {
            TreeNode treeNode = nodeQue.poll();
            int depth = depthQue.poll();
            if (treeNode != null) {
                if (depthVal.get(depth) == null) {
                    depthVal.put(depth, treeNode.val);
                }
                nodeQue.add(treeNode.right);
                nodeQue.add(treeNode.left);
                depthQue.add(depth + 1);
                depthQue.add(depth + 1);
            }
        }

        List<Integer> val = new ArrayList<>();
        for (int i = 0; i < depthVal.size(); i++) {
            val.add(depthVal.get(i));
        }
        return val;
    }
}
