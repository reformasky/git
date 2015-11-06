package org.xuan;

import util.TreeNode;

/**
 * Created by xuan on 2015/11/5.
 */
public class PreoderInOrderToBT {
    public TreeNode buildTree(int[] preorder, int[] inorder) {
        if (preorder == null || preorder.length == 0) {
            return null;
        }
        return buildTree(preorder, inorder, 0, preorder.length - 1, 0, inorder.length - 1);
    }

    private TreeNode buildTree(int[] preorder, int[] inorder, int preorderLow, int preorderHigh,
                               int inorderLow, int inorderHigh) {
        if (preorderLow > preorderHigh) {
            return null;
        }
        if ( preorderHigh - preorderLow != inorderHigh - inorderLow) {
            throw new  IllegalArgumentException();
        }
        else {
            int rootValue = preorder[preorderLow];
            int rightvalueInLeftChild;
            TreeNode result = new TreeNode(rootValue);
            int rootIndexInInOrder = findIndex(inorder, inorderLow, inorderHigh, rootValue);
            if (rootIndexInInOrder > inorderLow) {
                rightvalueInLeftChild = (rootIndexInInOrder - inorderLow) + preorderLow ;
                result.left = buildTree(preorder, inorder, preorderLow + 1, rightvalueInLeftChild,
                        inorderLow ,  rootIndexInInOrder - 1);
                result.right = buildTree(preorder, inorder, rightvalueInLeftChild + 1, preorderHigh,
                        rootIndexInInOrder + 1, inorderHigh);
            }
            else {
                result.left = null;
                result.right = buildTree(preorder, inorder, preorderLow + 1, preorderHigh,
                        inorderLow + 1, inorderHigh);
            }
            return result;
        }
    }

    private int findIndex(int[] array, int low, int high, int value) {
        for (int index = low; index <= high; index++) {
            if (array[index] == value) {
                return index;
            }
        }
        throw new IllegalArgumentException();
    }
}
