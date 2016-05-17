package org.xuan;

import util.TreeNode;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by xzhou2 on 5/16/16.
 */
public class BinaryTreePaths {
    public List<String> binaryTreePaths(TreeNode root) {
        List<String> result = new ArrayList<>();
        if (root == null) {
            return result;
        }
        List<Integer> path = new ArrayList<>();
        binaryTreePaths(root, path, result);
        return result;
    }

    private void binaryTreePaths(TreeNode root, List<Integer> path, List<String> result) {
        path.add(root.val);
        if (root.left == null && root.right == null) {
            result.add(buildPath(path));
        }
        else {
            if (root.left != null) {
                binaryTreePaths(root.left, path, result);
            }
            if (root.right != null) {
                binaryTreePaths(root.right, path, result);
            }
        }
        path.remove(path.size() -1);
    }

    private String buildPath(List<Integer> path) {
        StringBuilder sb = new StringBuilder();
        sb.append(path.get(0));
        for(int i = 1; i < path.size();i++) {
            sb.append("->");
            sb.append(path.get(i));
        }
        return sb.toString();
    }
}
