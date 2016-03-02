package org.xuan;

import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import util.TreeLinkNode;

/**
 * Created by xuan on 2016/2/29.
 */
public class PopulateNextRightPointerIITest {
    @DataProvider(name = "data")
    public Object[][] data() {
        TreeLinkNode node1 = new TreeLinkNode(1),
                node2 = new TreeLinkNode(2),
                node3 = new TreeLinkNode(3),
                node4 = new TreeLinkNode(4),
                node5 = new TreeLinkNode(5),
                node6 = new TreeLinkNode(6),
                node7 = new TreeLinkNode(7),
                node8 = new TreeLinkNode(8),
                node9 = new TreeLinkNode(9);
        node1.left = node2;
        node2.left = node3;
        node2.right = node4;
        node3.left = node5;
        node4.left = node6;
        node4.right = node7;
        node6.left = node8;
        node7.left = node9;

        return new Object[][] {
                {
                        node1
                }
        };
    }

    @Test(dataProvider = "data")
    public void test(TreeLinkNode root) {
        new PopulateNextRightPointerII().connect(root);
        Assert.assertEquals(root.val, 1);
    }
}
