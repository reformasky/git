package org.xuan;

import util.TreeNode;

/**
 * Created by xuan on 2016/3/5.
 */
public class SumRootToLeafNumbers {
    int sum = 0;
    public int sumNumbers(TreeNode root) {
        if (root == null) {
            return sum;
        }
        int cache = 0;
        sumNumbers(root, cache);
        return sum;
    }

    public void sumNumbers(TreeNode root, int cache) {
        cache = cache * 10 + root.val;
        if (root.left == null && root.right == null) {
            sum += cache;
        }
        if (root.left != null) {
            sumNumbers(root.left, cache);
        }
        if (root.right != null) {
            sumNumbers(root.right, cache);
        }
        cache = cache / 10;
    }
}
