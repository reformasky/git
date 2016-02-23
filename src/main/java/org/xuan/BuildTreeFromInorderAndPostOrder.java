package org.xuan;

import util.TreeNode;

/**
 * Created by xuan on 2016/2/22.
 */
public class BuildTreeFromInorderAndPostOrder {
    public TreeNode buildTree(int[] inorder, int[] postorder) {
        if (inorder == null || postorder == null || inorder.length != postorder.length) {
            throw new IllegalArgumentException();
        }
        return buildTree(inorder, 0, inorder.length - 1, postorder, 0, postorder.length - 1);
    }

    private TreeNode buildTree(int[] inorder, int begin1, int end1, int[] postorder, int begin2, int end2) {
        if (begin1 == end1) {
            return new TreeNode(inorder[begin1]);
        }
        if (begin1 > end1) {
            return null;
        }
        TreeNode node = new TreeNode(postorder[end2]);
        int index = findIndex(inorder, begin1, end1, node.val);
        node.left = buildTree(inorder, begin1, index - 1, postorder, begin2, index - 1 - begin1 + begin2);
        node.right = buildTree(inorder, index + 1, end1, postorder, index - begin1 + begin2, end2 - 1);
        return node;
    }

    private int findIndex(int[] inorder, int begin, int end, int val) {
        for(int i = begin; i <= end; i++) {
            if (inorder[i] == val) {
                return i;
            }
        }
        return -1;
    }
}
