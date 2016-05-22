package org.xuan;

import util.TreeNode;

import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Queue;

/**
 * Created by xzhou2 on 5/22/16.
 */
public class Codec {
    // Encodes a tree to a single string.
    public String serialize(TreeNode root) {
        StringBuilder sb = new StringBuilder();
        serialize(root, sb);
        return sb.toString();
    }

    private void serialize(TreeNode root, StringBuilder sb) {
        if (root == null) {
            sb.append('#');
            sb.append(' ');
            return;
        }
        sb.append(root.val);
        sb.append(' ');
        serialize(root.left, sb);
        serialize(root.right, sb);
    }

    // Decodes your encoded data to tree.
    public TreeNode deserialize(String data) {
        if (data == "") {
            return null;
        }
        Queue<String> tokens = new ArrayDeque<>(Arrays.asList(data.substring(0, data.length() - 1).split(" ")));
        return deserialize(tokens);
    }

    private TreeNode deserialize(Queue<String> tokens) {
        String token = tokens.poll();
        if (token.equals("#")) {
            return null;
        }
        TreeNode root = new TreeNode(Integer.parseInt(token));
        root.left = deserialize(tokens);
        root.right = deserialize(tokens);
        return root;
    }
}
