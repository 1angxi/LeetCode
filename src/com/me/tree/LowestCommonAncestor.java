package com.me.tree;

import java.util.ArrayList;
import java.util.List;

/**
 * 给定一个二叉搜索树, 找到该树中两个指定节点的最近公共祖先。
 * <p>
 * 百度百科中最近公共祖先的定义为：“对于有根树 T 的两个结点 p、q，最近公共祖先表示为一个结点 x，满足 x 是 p、q 的祖先且 x 的深度尽可能大（一个节点也可以是它自己的祖先）。”
 * <p>
 * 例如，给定如下二叉搜索树:  root = [6,2,8,0,4,7,9,null,null,3,5]
 * <p>
 * <p>
 * <p>
 * 示例 1:
 * <p>
 * 输入: root = [6,2,8,0,4,7,9,null,null,3,5], p = 2, q = 8
 * 输出: 6
 * 解释: 节点 2 和节点 8 的最近公共祖先是 6。
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/lowest-common-ancestor-of-a-binary-search-tree
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 *
 * @author qiankun
 * @version 2021/12/29
 */
public class LowestCommonAncestor {

    /**
     * 因为是二叉搜索树。因此求最大公共路径变为求，从根节点开始，首个能把数据分开的节点。
     */
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        if (p.val > root.val && q.val > root.val) {
            return lowestCommonAncestor(root.right, p, q);
        } else if (p.val < root.val && q.val < root.val) {
            return lowestCommonAncestor(root.left, p, q);
        } else {
            return root;
        }
    }

    /**
     * 两次遍历路径。求分叉点前的节点
     */
    public TreeNode lowestCommonAncestorV2(TreeNode root, TreeNode p, TreeNode q) {
        List<TreeNode> a = getLink(root, p);
        List<TreeNode> b = getLink(root, q);

        int len = Math.max(a.size(), b.size());
        for (int i = 0; i < len; i++) {
            if (i == a.size() || i==b.size()|| a.get(i) != b.get(i)) {
                return a.get(i - 1);
            }
        }
        return null;
    }

    public List<TreeNode> getLink(TreeNode root, TreeNode target) {
        List<TreeNode> node = new ArrayList<>();
        TreeNode a = root;
        while (a != null) {
            node.add(a);
            if (a.val == target.val) return node;
            if (a.val > target.val) {
                a = a.left;
            } else {
                a = a.right;
            }
        }

        return node;
    }


    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode() {
        }

        TreeNode(int val) {
            this.val = val;
        }

        TreeNode(int val, TreeNode left, TreeNode right) {
            this.val = val;
            this.left = left;
            this.right = right;
        }
    }
}
