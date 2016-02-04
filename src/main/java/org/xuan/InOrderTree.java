package org.xuan;

import util.TreeNode;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

/**
 * Created by xuan on 2016/1/31.
 */
public class InOrderTree {
    public List<Integer> inorderTraversal(TreeNode root) {
        List<Integer> result = new ArrayList<Integer>();
        if (root == null) {
            return result;
        }
        Stack<TreeNode> stack = new Stack<>();
        stack.push(root);
        TreeNode node = root.left;
        while(node != null) {
            stack.add(node);
            node = node.left;
        }
        while(!stack.isEmpty()) {
            node = stack.pop();
            result.add(node.val);
            node = node.right;
            while(node != null) {
                stack.add(node);
                node = node.left;
            }
        }

        return result;
    }
}
