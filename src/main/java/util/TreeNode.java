package util;

/**
 * Created by xuan on 2015/11/5.
 */
public class TreeNode {
    public int val;
    public TreeNode left;
    public TreeNode right;
    public TreeNode(int x) { val = x; }

    public static TreeNode constructBST(int[] input) {
        return constructBST(input, 0, input.length - 1);
    }

    private static TreeNode constructBST(int[] input, int begin, int end) {
        if (begin == end) {
            return new TreeNode(input[begin]);
        }
        if (begin > end) {
            return null;
        }
        int mid = begin + (end - begin)/2;
        TreeNode node = new TreeNode(input[mid]);
        node.left = constructBST(input, begin, mid - 1);
        node.right = constructBST(input, mid + 1, end);
        return node;
    }

   public static TreeNode addNode(TreeNode node, int val) {
       if (node == null) {
           return new TreeNode(val);
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