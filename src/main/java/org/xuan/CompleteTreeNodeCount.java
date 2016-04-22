package org.xuan;

import util.TreeNode;

import java.util.Stack;

/**
 * Created by xzhou2 on 4/19/16.
 */
public class CompleteTreeNodeCount {
    public int countNodes(TreeNode root) {
        if (root == null) {
            return 0;
        }
        int height = 1;
        TreeNode leftMost = root.left,
                rightMost = root.right,
                leftRight = root.left;
        if (leftMost == null) {
            return 1;
        }
        if (rightMost == null) {
            return 2;
        }
        while(leftMost.left != null) {
            leftMost = leftMost.left;
            rightMost = rightMost.right;
            leftRight = leftRight.right;
            height++;
        }

        if (rightMost != null) {
            //right child is fully complete tree
            return (1 << (height + 1)) - 1;
        }
        if (leftRight == null) {
            return countNodes(root.left) + (1 << (height -1));
        }
        else {
            return countNodes(root.right) + (1 << (height));
        }
    }
}
