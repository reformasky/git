import apple.laf.JRSUIUtils;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import org.xuan.CompleteTreeNodeCount;
import util.TreeNode;

import java.util.ArrayDeque;
import java.util.Queue;

/**
 * Created by xzhou2 on 4/19/16.
 */
public class CompleteTreeNodeCountTest {
    @DataProvider(name = "data")
    public Object[][] data() {
        return new Object[][] {
                {new int[]{4, 1024}}
        };
    }

    @Test(dataProvider = "data")
    public void test(int[] input) {
        for(int j = input[0]; j <= input[1]; j++) {
            int[] ints = new int[j];
            for(int k = 1; k <= j; k++) {
                ints[k-1] = k;
            }
            TreeNode treeNode = buildCompleteTree(ints);
            Assert.assertEquals(new CompleteTreeNodeCount().countNodes(treeNode), j);
        }

    }

    private TreeNode buildCompleteTree(int[] input){
        TreeNode result = new TreeNode(input[0]);
        Queue<TreeNode> queue = new ArrayDeque<>();
        queue.add(result);
        TreeNode node = null;
        for(int i = 1; i < input.length; i++) {
            if (node == null) {
                node = queue.remove();
            }
            if (node.left == null) {
                node.left = new TreeNode(input[i]);
                queue.add(node.left);
            }
            else if (node.right == null){
                node.right = new TreeNode(input[i]);
                queue.add(node.right);
            }
            else {
                i--;
                node = null;
            }
        }
        return result;
    }
}
