package org.xuan;

import util.TreeNode;

/**
 * Created by xuan on 2016/2/28.
 */
public class FlatBT {
    public void flatten(TreeNode root) {
        if (root == null) {
            return;
        }
        TreeNode curr = root;
        while(curr != null) {
            if (curr.left == null) {
                curr = curr.right;
            }
            else {
                TreeNode temp = curr.left;
                while(temp.right != null) {
                    temp = temp.right;
                }
                temp.right = curr.right;
                curr.right = curr.left;
                curr.left = null;
                curr = curr.right;

            }
        }
    }
}
