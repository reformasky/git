package util;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by xuan on 2015/11/5.
 */
public class TreeNodePreOrder {
    public static List<Integer> preOrderTreeNode(TreeNode root) {
        ArrayList<Integer> result = new ArrayList<Integer>();
        if (root == null) {
            return result;
        }
        preOderTreeNode(root, result);
        return result;
    }

    private static void preOderTreeNode(TreeNode root, List<Integer> result) {
        if (root == null) {
            return;
        }
        result.add(root.val);
        preOderTreeNode(root.left, result);
        preOderTreeNode(root.right, result);

    }
}
