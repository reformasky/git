package org.xuan;

import util.TreeNode;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by xuan on 2016/3/5.
 */
public class MaxPathSumBT {
    int max= Integer.MIN_VALUE;
    public int maxPathSum(TreeNode root) {
        maxRootToLeaf(root);
        return max;
    }

    private int maxRootToLeaf(TreeNode root) {
        if (root == null) {
            return Integer.MIN_VALUE;
        }
        int val = root.val;
        int left = maxRootToLeaf(root.left), right = maxRootToLeaf(root.right);
        int larger = Math.max(left, right);
        int smaller = Math.min(left, right);
        int sum;
        if (val > 0) {
            sum = val;
            if (larger > 0) {
                sum += larger;
                if (smaller >0) {
                    sum += smaller;
                }
            }
        }
        else {
            if (larger < 0) {
                sum = Math.max(val, larger);
            }
            else if (smaller < 0 || smaller + val < 0){
                sum = larger;
            }
            else {
                sum = larger + smaller + val;
            }
        }
        if (larger > 0) {
            val += larger;
        }
        if (max < sum) {
            max = sum;
        }
        return val;
    }
}
