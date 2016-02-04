package org.xuan;

import util.TreeNode;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by xuan on 2016/2/3.
 */
public class AllBsts {
    static final Map<Range, List<TreeNode>> map;
    static {
        map = new HashMap<>();
    }
    public List<TreeNode> generateTrees(int n) {
        if (n < 1) {
            return new ArrayList<TreeNode>();
        }
        return generateTrees(1, n);
    }

    private List<TreeNode> generateTrees(int begin, int end) {
        if (map.containsKey(new Range(begin, end))) {
            return map.get(new Range(begin, end));
        }
        List<TreeNode> result = new ArrayList<>();
        if (begin > end) {
            return null;
        }
        if (begin == end) {
            TreeNode node = new TreeNode(begin);
            result.add(node);
            map.put(new Range(begin, begin), result);
            return result;
        }

        for(int i = begin; i <= end; i++) {
            List<TreeNode> left = generateTrees(begin, i - 1);
            List<TreeNode> right = generateTrees(i + 1, end);
            if (left != null && right != null) {
                for(TreeNode leftNode : left) {
                    for(TreeNode rightNode : right) {
                        TreeNode root = new TreeNode(i);
                        root.left = leftNode;
                        root.right = rightNode;
                        result.add(root);
                    }
                }
            }
            else {
                if (left == null && right == null) {
                    TreeNode root = new TreeNode(i);
                    root.left = null;
                    root.right = null;
                    result.add(root);
                }
                else if (left == null) {
                    for(TreeNode rightNode : right) {
                        TreeNode root = new TreeNode(i);
                        root.right = rightNode;
                        result.add(root);
                    }
                }
                else {
                    for(TreeNode leftNode : left) {
                        TreeNode root = new TreeNode(i);
                        root.left = leftNode;
                        result.add(root);
                    }
                }
            }

        }
        map.put(new Range(begin, end), result);
        return result;

    }

    static class Range{
        public final int begin;
        public final int end;

        public Range(int b, int e) {
            begin = b;
            end = e;
        }

        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (o == null || getClass() != o.getClass()) return false;

            Range range = (Range) o;

            if (begin != range.begin) return false;
            if (end != range.end) return false;

            return true;
        }

        @Override
        public int hashCode() {
            int result = begin;
            result = 31 * result + end;
            return result;
        }
    }
}
