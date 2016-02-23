package org.xuan;

import util.TreeNode;

/**
 * Created by xuan on 2016/2/3.
 */
public class IsValidBST {
    public boolean isValidBST(TreeNode root) {
        return isValidBST(root, Long.MIN_VALUE, Long.MAX_VALUE);
    }
    private boolean isValidBST(TreeNode root, long min, long max) {
        return root==null || (root.val<max && root.val>min && isValidBST(root.left, min, root.val) && isValidBST(root.right, root.val, max));
    }
}
