package org.xuan;

import util.TreeNode;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by xzhou2 on 6/14/16.
 */
public class HouseRobberIII {
    Map<TreeNode, Integer> pos = new HashMap<>(),
            neg = new HashMap<>();
    public int rob(TreeNode root) {
        if (root == null) {
            return 0;
        }
        return helper(root, true);
    }

    public int helper(TreeNode root, boolean canTake) {
        if (root == null) {
            return 0;
        }
        int result;
        if(canTake) {
            if (pos.containsKey(root)) {
                return pos.get(root);
            }

            if (getVal(root) > getVal(root.left) + getVal(root.right)) {
                result = root.val + helper(root.left, false) + helper(root.right, false);
            }
            else {
                result = Math.max(root.val + helper(root.left, false) + helper(root.right, false),
                        helper(root.left, true) + helper(root.right, true));
            }
            pos.put(root, result);
        }
        else {
            if (neg.containsKey(root)) {
                return neg.get(root);
            }
            result = helper(root.left, true) + helper(root.right, true);
            neg.put(root, result);
        }
        return result;

    }

    private int getVal(TreeNode node) {
        return node == null ? 0 : node.val;
    }
}
