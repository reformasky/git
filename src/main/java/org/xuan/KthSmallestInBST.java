package org.xuan;

import util.TreeCounterNode;
import util.TreeNode;

/**
 * Created by xzhou2 on 4/25/16.
 */
public class KthSmallestInBST {
    int count = 0;
    int result;

    public int kthSmallest(TreeCounterNode root, int k) {
        if (root.count < 0) {
            buildCount(root);
        }
        if (root.count == k - 1) {
            return root.val;
        }
        if (root.count > k -1) {
            return kthSmallest(root.left, k);
        }
        return kthSmallest(root.right, k);
    }

    private void  buildCount(TreeCounterNode node) {
        if (node.left != null) {
            buildCount(node.left);
        }
        node.count = count++;
        if (node.right != null) {
            buildCount(node.right);
        }
    }
}
