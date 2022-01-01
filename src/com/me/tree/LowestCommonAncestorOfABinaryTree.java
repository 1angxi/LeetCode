package com.me.tree;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

/**
 * 给定一个二叉树, 找到该树中两个指定节点的最近公共祖先。
 *
 * 百度百科中最近公共祖先的定义为：“对于有根树 T 的两个节点 p、q，最近公共祖先表示为一个节点 x，满足 x 是 p、q 的祖先且 x 的深度尽可能大（一个节点也可以是它自己的祖先）。”
 *
 *  
 *
 * 示例 1：
 *
 *
 * 输入：root = [3,5,1,6,2,0,8,null,null,7,4], p = 5, q = 1
 * 输出：3
 * 解释：节点 5 和节点 1 的最近公共祖先是节点 3 。
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/lowest-common-ancestor-of-a-binary-tree
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class LowestCommonAncestorOfABinaryTree {
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        List<TreeNode> link1 = new ArrayList<>();
        List<TreeNode> link2 = new ArrayList<>();
        getNodeLink(root, p, link1);
        getNodeLink(root, q, link2);

        Collections.reverse(link1);
        Collections.reverse(link2);

        int i = 0;
        while (i < link1.size() && i < link2.size()) {
            if(link1.get(i) != link2.get(i)){
                return link1.get(i-1);
            }
            i++;
        }
        if (i < link1.size()) {
            return link1.get(i - 1);
        }

        if (i < link2.size()) {
            return link2.get(i - 1);
        }

        return null;
    }

    public boolean getNodeLink(TreeNode root, TreeNode p, List<TreeNode> link) {
        if(root == null){
            return false;
        }

        if (root == p) {
            link.add(root);
            return true;
        }

        if(getNodeLink(root.left, p, link) || getNodeLink(root.right, p, link)){
            link.add(root);
            return true;
        }

        return false;
    }


    /**
     * 官方题解就是通过递归去找p或q，如果找到了就返回找到的p或q。
     */
    public TreeNode lowestCommonAncestorV2(TreeNode root, TreeNode p, TreeNode q) {
        if (root==p||root==q) {
            return root;
        }
        if (root!=null){
            TreeNode lNode=lowestCommonAncestorV2(root.left,p,q);
            TreeNode rNode=lowestCommonAncestorV2(root.right,p,q);
            if (lNode!=null&&rNode!=null)
                return root;
            else if(lNode==null) {//两个都在右子树
                return rNode;
            }
            else { //两个都在左子树里面
                return lNode;
            }
        }
        return null;
    }
}
