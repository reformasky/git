package org.xuan;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by xzhou2 on 5/25/16.
 */
public class NumArray_Mutable {
    public static class NumArray {
        Node root;
        int[] nums;
        public NumArray(int[] nums) {
            if (nums != null) {
                root = helper(nums, 0, nums.length -1);
                this.nums = nums;
            }
        }

        void update(int i, int val) {
            int delta = val - nums[i];
            nums[i] = val;
            Node node = root;
            while(node != null) {
                node.sum += delta;
                if (node.left != null) {
                    node = node.left.end >= i ? node.left : node.right;
                }
                else {
                    node = null;
                }
            }
        }

        public int sumRange(int i, int j) {
            return sumRange(i, j, root);
        }


        private int sumRange(int i, int j, Node node) {
            if (i > j) {
                return 0;
            }
            if (i == node.begin && j == node.end) {
                return node.sum;
            }
            if (i>= node.left.begin && j <= node.left.end) {
                return sumRange(i, j, node.left);
            }
            else if (i >= node.right.begin && j <= node.right.end) {
                return sumRange(i, j, node.right);
            }
            else {
                return sumRange(i, node.left.end, node.left) + sumRange(node.left.end + 1, j, node.right);
            }
        }


        class Node{
            int begin;
            int end;
            int sum;

            Node(int b, int e, int s) {
                begin = b;
                end = e;
                sum = s;;
            }

            Node left, right;
        }

        private Node helper(int[] nums, int begin, int end) {
            if (begin == end) {
                return new Node(begin, end, nums[begin]);
            }
            Node node = new Node(begin, end, 0);
            int mid = begin + (end - begin) /2;
            node.left = helper(nums, begin, mid);
            node.right = helper(nums, mid + 1, end);
            node.sum = node.left.sum + node.right.sum;
            return node;
        }
    }


// Your NumArray object will be instantiated and called as such:
// NumArray numArray = new NumArray(nums);
// numArray.sumRange(0, 1);
// numArray.update(1, 10);
// numArray.sumRange(1, 2);
}
