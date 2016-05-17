package org.xuan;

import util.TreeNode;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by xzhou2 on 4/26/16.
 */
public class LowestCommonAncestor {
    public TreeNode lowestCommonAncestorBST(TreeNode root, TreeNode p, TreeNode q) {
        if (root == null) {
            return null;
        }
        if ((root.val >= p.val && root.val <= q.val) || (root.val <= p.val && root.val >= q.val) ) {
            return root;
        }
        if (root.val > p.val) {
            return lowestCommonAncestorBST(root.left, p, q);
        }
        else {
            assert root.val < p.val && root.val < q.val;
            return lowestCommonAncestorBST(root.right, p, q);
        }
    }
    public TreeNode lowestCommonAncestorVerbal(TreeNode root, TreeNode p, TreeNode q) {
        List<Boolean> path1 = new ArrayList<>(),
                path2 = new ArrayList<>();
        helper(root, p, path1);
        helper(root, q, path2);
        TreeNode result = root;
        for(int i = 0; i < Math.min(path1.size(), path2.size()); i++) {
            if (path1.get(i) != path2.get(i)) {
                return result;
            }
            result = path1.get(i) ? result.left : result.right;
        }
        return result;
    }

    private boolean helper(TreeNode root, TreeNode p, List<Boolean> path) {
        //assume that the root is p's ancestor
        if (root == p) {
            return true;
        }

        if (root.left != null) {
            path.add(true);
            if (helper(root.left, p, path)) {
                return true;
            }
            else {
                path.remove(path.size() - 1);
            }
        }

        if (root.right != null) {
            path.add(false);
            if (helper(root.right, p, path)) {
                return true;
            }
            else {
                path.remove(path.size() - 1);
            }
        }
        return false;
    }

    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        if(root == null) return null;
        if(root == p || root == q) return root;
        TreeNode left = lowestCommonAncestor(root.left, p, q);
        TreeNode right = lowestCommonAncestor(root.right, p, q);
        return left != null && right != null ? root : left == null ? right : left;
    }
}
