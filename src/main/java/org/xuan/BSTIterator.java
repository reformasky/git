package org.xuan;

import util.TreeNode;

import java.util.Stack;

/**
 * Created by xzhou2 on 4/5/16.
 */
public class BSTIterator {
    Stack<TreeNode> stack;
    public BSTIterator(TreeNode root) {
        stack = new Stack<>();
        TreeNode node = root;
        while(node != null) {
            stack.push(node);
            node = node.left;
        }
    }

    /** @return whether we have a next smallest number */
    public boolean hasNext() {
        return !stack.isEmpty();
    }

    /** @return the next smallest number */
    public int next() {
        if (stack.isEmpty()) {
            throw new RuntimeException();
        }
        TreeNode node = stack.pop();
        int result = node.val;
        node = node.right;
        while(node != null) {
            stack.push(node);
            node = node.left;
        }
        return result;
    }
}