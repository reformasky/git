package org.xuan;

import util.TreeNode;

/**
 * Created by xuan on 2016/2/24.
 */
public class SortedArrayToBST {
    public TreeNode sortedArrayToBST(int[] nums) {
        if (nums == null || nums.length == 0) {
            return null;
        }
        return sortedArrayToBST(nums, 0, nums.length - 1);
    }

    private TreeNode sortedArrayToBST(int[] nums, int begin, int end) {
        if (begin == end) {
            return new TreeNode(nums[begin]);
        }
        if (begin > end) {
            return null;
        }
        int mid = begin + (end- begin) / 2;
        TreeNode node = new TreeNode(nums[mid]);
        node.left = sortedArrayToBST(nums, begin, mid - 1);
        node.right = sortedArrayToBST(nums, mid + 1, end);
        return node;
    }
}
