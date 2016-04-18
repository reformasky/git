package org.xuan;

import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import util.TreeNode;
import util.TreeNodePreOrder;

import java.util.List;

/**
 * Created by xuan on 2015/11/5.
 */
public class TestPreoderInorderToBT {



    @DataProvider(name = "value")
    public Object[][] value() {
        return new Object[][] {
               /* {null,null, new ArrayList<Integer>()},
                {new int[] {1}, new int[] {1}, new ArrayListBuilder().add(1).build()},*/
               /* {new int[]{1,2,3}, new int[]{1,2,3}, null},*/
                {new int[] {1,2,3}, new int[] {3,2,1}},
                {new int[] {1,2,3,4}, new int[] {3,2,4,1}},
                {new int[] {1,2,3,4,5}, new int[] {3,2,4,1,5}}

        };
    }

    @Test(dataProvider = "value")
    public void test(int[] preorder, int[] inorder) {
        TreeNode node = new PreoderInOrderToBT().buildTree(preorder, inorder);
        List<Integer> preOrderResult = TreeNodePreOrder.preOrderTreeNode(node);
        int index = 0;
        for(Integer i : preOrderResult) {
            if (i != preorder[index++]) {
                Assert.fail();
            }
        }
    }
}
