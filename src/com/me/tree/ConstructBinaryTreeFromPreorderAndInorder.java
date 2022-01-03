package com.me.tree;

import java.util.HashMap;
import java.util.Map;

/**
 * 给定一棵树的前序遍历 preorder 与中序遍历  inorder。请构造二叉树并返回其根节点。
 *
 *  
 *
 * 示例 1:
 *
 *
 * Input: preorder = [3,9,20,15,7], inorder = [9,3,15,20,7]
 * Output: [3,9,20,null,null,15,7]
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/construct-binary-tree-from-preorder-and-inorder-traversal
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class ConstructBinaryTreeFromPreorderAndInorder {

    Map<Integer, Integer> inMap = new HashMap<>();
    public TreeNode myBuildTree(int[] preorder, int[] inorder, int preorder_left, int preorder_right, int inorder_left, int inorder_right) {

        if (preorder_left > preorder_right || inorder_left > inorder_right) {
            return null;
        }

        int rootVal = preorder[preorder_left];

        int inRootIndex = inMap.get(rootVal);

        int leftLen = inRootIndex - inorder_left;
        int rightLen = inorder_right - inRootIndex;

        TreeNode root = new TreeNode(rootVal);

        root.left = myBuildTree(preorder, inorder, preorder_left + 1, preorder_left + leftLen,
                inRootIndex - leftLen,
                inRootIndex - 1);
        root.right = myBuildTree(preorder, inorder, preorder_left + leftLen + 1, preorder_left + leftLen + rightLen,
                inRootIndex + 1, inRootIndex + rightLen);

        return root;
    }

    public TreeNode buildTree(int[] preorder, int[] inorder) {
        for (int i = 0; i < inorder.length; i++) {
            inMap.put(inorder[i], i);
        }

        return myBuildTree(preorder, inorder, 0, preorder.length - 1, 0, inorder.length - 1);
    }
}
