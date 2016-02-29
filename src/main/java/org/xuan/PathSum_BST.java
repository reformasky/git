package org.xuan;

import util.TreeNode;

/**
 * Created by xuan on 2016/2/28.
 */
public class PathSum_BST {
    public boolean hasPathSum(TreeNode root, int sum) {
        if (root == null) {
            return false;
        }
        if (root.left == null && root.right == null) {
            return root.val == sum;
        }
        int target = sum - root.val;
        return hasPathSum(root.left, target) || hasPathSum(root.right, target);
    }
}
