package com.me.backtrace;


import java.util.LinkedList;
import java.util.Queue;

/**
 * 给你二叉树的根节点 root 和一个表示目标和的整数 targetSum 。判断该树中是否存在 根节点到叶子节点 的路径，这条路径上所有节点值相加等于目标和 targetSum 。如果存在，返回 true ；否则，返回 false 。
 * <p>
 * 叶子节点 是指没有子节点的节点。
 * <p>
 * 输入：root = [5,4,8,11,null,13,4,7,2,null,null,null,1], targetSum = 22
 * 输出：true
 * 解释：等于目标和的根节点到叶节点路径如上图所示。
 * <p>
 * 示例 3：
 * <p>
 * 输入：root = [], targetSum = 0
 * 输出：false
 * 解释：由于树是空的，所以不存在根节点到叶子节点的路径。
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/path-sum
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class PathSum {
    public boolean hasPathSum(TreeNode root, int targetSum) {
        if (root == null) {
            return false;
        }

        if (root.left == null && root.right == null) {
            return root.val == targetSum;
        }


        if (root.left != null && hasPathSum(root.left, targetSum - root.val)) {
            return true;
        }
        if (root.right != null && hasPathSum(root.right, targetSum - root.val)) {
            return true;
        }

        return false;
    }

    public boolean hasPathSumV2(TreeNode root, int targetSum) {
        if (root == null) {
            return false;
        }

        Queue<TreeNode> queue = new LinkedList<>();
        Queue<Integer> valQue = new LinkedList<>();
        queue.add(root);
        valQue.add(root.val);
        while (!queue.isEmpty()) {
            int len = queue.size();
            for(int i = 0;i<len;i++) {
                TreeNode pop = queue.poll();
                Integer val = valQue.poll();
                if(pop.left == null && pop.right == null){
                    if(val == targetSum){
                        return true;
                    }
                }
                if (pop.left != null) {
                    queue.add(pop.left);
                    valQue.add(pop.left.val + val);
                }

                if(pop.right != null){
                    queue.add(pop.right);
                    valQue.add(pop.right.val + val);
                }
            }
        }
        return false;

    }
}
