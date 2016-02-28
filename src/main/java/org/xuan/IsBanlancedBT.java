package org.xuan;

import util.TreeNode;

import java.util.HashMap;

/**
 * Created by xuan on 2016/2/27.
 */
public class IsBanlancedBT {
    private HashMap<TreeNode, Integer> cache = new HashMap<>();
    public boolean isBalanced(TreeNode root) {
        if (root == null) {
            return true;
        }
        return isBalanced(root.left) && isBalanced(root.right)
                && Math.abs(height(root.left) - height(root.right)) <= 1;
    }

    private int height(TreeNode root) {
        if (root == null) {
            return 0;
        }
        if (cache.containsKey(root)) {
            return cache.get(root);
        }
        Integer result =  1 + Math.max(height(root.left), height(root.right));
        cache.put(root, result);
        return result;
    }
}
