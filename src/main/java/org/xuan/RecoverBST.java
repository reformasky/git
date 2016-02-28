package org.xuan;

import util.TreeNode;

/**
 * Created by xuan on 2016/2/23.
 */
public class RecoverBST {
    TreeNode pre, first, second;
    public void recoverTree_logn(TreeNode root) {
        if (root == null) {
            return;
        }
        if (first != null && second != null) {
            int val = first.val;
            first.val = second.val;
            second.val = val;
        }
    }

    private void inOrder(TreeNode node) {
        if (node.left != null) {
            inOrder(node.left);
        }
        if (pre != null && pre.val > node.val) {
            if (first == null) {
                first = pre;
            }
            else {
                second = node;
            }
        }
        pre = node;
        if (node.right != null) {
            inOrder(node.right);
        }
    }
}
