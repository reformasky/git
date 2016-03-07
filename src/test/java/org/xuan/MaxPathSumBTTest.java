package org.xuan;

import org.testng.Assert;
import org.testng.annotations.Test;
import util.TreeNode;

/**
 * Created by xuan on 2016/3/5.
 */
public class MaxPathSumBTTest {
    @Test
    public void test() {
        TreeNode root = new TreeNode(3);
        TreeNode left = new TreeNode(1);
        TreeNode left2 = new TreeNode(2);
        root.left = left;
        left.left = left2;
        Assert.assertEquals(new MaxPathSumBT().maxPathSum( root), 0);
    }
}
