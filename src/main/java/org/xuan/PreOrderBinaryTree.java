package org.xuan;

import util.TreeNode;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

/**
 * Created by xzhou2 on 3/29/16.
 */
public class PreOrderBinaryTree {
    public List<Integer> preorderTraversal(TreeNode root) {
        List<Integer> result = new ArrayList<>();
        Stack<TreeNode> stack = new Stack<>();
        TreeNode curr = root;
        while(curr != null || !stack.isEmpty()) {
            if (curr == null) {
                curr = stack.pop();
            }
            result.add(curr.val);
            if (curr.right != null) {
                stack.push(curr.right);
            }
            curr = curr.left;
        }
        return result;
    }
}
