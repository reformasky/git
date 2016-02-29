package org.xuan;

import util.TreeNode;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by xuan on 2016/2/28.
 */
public class PathSumII_BT {
    public List<List<Integer>> pathSum(TreeNode root, int sum) {
        List<List<Integer>> result = new ArrayList<>();
        if (root == null) {
            return result;
        }
        pathSum(root, sum, result, new ArrayList<Integer>());
        return result;
    }

    private void pathSum(TreeNode node, int sum, List<List<Integer>> result, List<Integer> curr) {
        if (node == null) {
            return;
        }
        curr.add(node.val);
        if (node.left == null && node.right == null && node.val == sum) {
            result.add(new ArrayList(curr));
        }
        pathSum(node.left, sum - node.val, result, curr);
        pathSum(node.right, sum - node.val, result, curr);
        curr.remove(curr.size() - 1);
    }
}
