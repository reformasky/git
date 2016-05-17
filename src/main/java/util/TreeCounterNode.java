package util;

/**
 * Created by xzhou2 on 4/26/16.
 */
public class TreeCounterNode extends TreeNode {
    public int count;
    public TreeCounterNode left, right;

    public TreeCounterNode(int x) {
        super(x);
        count = -1;
    }
    public static TreeCounterNode constructBST(int[] input) {
        return constructBST(input, 0, input.length - 1);
    }

    private static TreeCounterNode constructBST(int[] input, int begin, int end) {
        if (begin == end) {
            return new TreeCounterNode(input[begin]);
        }
        if (begin > end) {
            return null;
        }
        int mid = begin + (end - begin)/2;
        TreeCounterNode node = new TreeCounterNode(input[mid]);
        node.left = constructBST(input, begin, mid - 1);
        node.right = constructBST(input, mid + 1, end);
        return node;
    }

    public static TreeCounterNode addNode(TreeCounterNode node, int val) {
        if (node == null) {
            return new TreeCounterNode(val);
        }
        if (val < node.val) {
            node.left = addNode(node.left, val);
        }
        else {
            node.right = addNode(node.right, val);
        }
        return node;
    }
}
