package com.me.tree;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

/**
 * 给你二叉树的根节点 root 和一个整数目标和 targetSum ，找出所有 从根节点到叶子节点 路径总和等于给定目标和的路径。
 *
 * 叶子节点 是指没有子节点的节点。
 *
 *  
 *
 * 示例 1：
 *
 *
 * 输入：root = [5,4,8,11,null,13,4,7,2,null,null,5,1], targetSum = 22
 * 输出：[[5,4,11,2],[5,8,4,5]]
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/path-sum-ii
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class PathSum {

    public List<List<Integer>> pathSum(TreeNode root, int targetSum) {
        List<List<Integer>> all = new ArrayList<>();

        if (root == null) {
            return all;
        }

        List<Integer> value = new LinkedList<>();

        validPath(root, targetSum, value, all);

        return all;
    }

    void validPath(TreeNode root, int targetSum, List<Integer> hasNode, List<List<Integer>> all) {
        if (root.left == null && root.right == null) {
            if (root.val == targetSum) {
                hasNode.add(root.val);
                all.add(new ArrayList<>(hasNode));
                hasNode.remove(hasNode.size() - 1);
                return;
            } else {
                return;
            }
        }

        hasNode.add(root.val);
        if (root.right != null) {
            validPath(root.right, targetSum - root.val, hasNode, all);
        }

        if (root.left != null) {
            validPath(root.left, targetSum - root.val, hasNode, all);
        }
        hasNode.remove(hasNode.size() - 1);
    }
}
