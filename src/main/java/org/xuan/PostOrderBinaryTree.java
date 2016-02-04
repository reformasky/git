package org.xuan;

import util.TreeNode;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

/**
 * Created by xuan on 2016/2/3.
 */
public class PostOrderBinaryTree {
    public List<Integer> postOrderBinaryTree(TreeNode root) {
        List<Integer> result = new ArrayList<>();
        if (root == null) {
            return result;
        }

        Stack<TreeNode> stack = new Stack<>();
        TreeNode previousNode = root;
        stack.push(root);
        while (! stack.isEmpty()) {
            TreeNode node = stack.peek();
            if (previousNode == node.left) {
                if (node.right != null) {
                    stack.push(node.right);
                }
                else {
                    result.add(node.val);
                    stack.pop();
                    previousNode = node;
                }
            }
            else if (previousNode == node.right) {
                result.add(node.val);
                stack.pop();
                previousNode = node;
            }
            else {
                if (node.left != null) {
                    stack.push(node.left);
                }
                else if (node.right != null) {
                    stack.push(node.right);
                }
                else {
                    result.add(node.val);
                    stack.pop();
                    previousNode = node;
                }
            }
        }
        return result;
    }
}