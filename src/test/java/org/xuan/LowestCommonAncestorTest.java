package org.xuan;

import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import util.TreeNode;

import java.util.Random;

/**
 * Created by xzhou2 on 4/26/16.
 */
public class LowestCommonAncestorTest {
    static TreeNode node5 = new TreeNode(5),
            node3 = new TreeNode(3),
            node2 = new TreeNode(2),
            node4 = new TreeNode(4),
            node1 = new TreeNode(1),

            node8 = new TreeNode(8),
            node6 = new TreeNode(6),
            node7 = new TreeNode(7),
            node9 = new TreeNode(9),
            node10 = new TreeNode(10);
    TreeNode[] treeNodes = new TreeNode[] {node1, node2, node3, node4, node5, node6, node7, node8, node9, node10};

    static {
        node5.left = node3;
        node3.left = node2;
        node2.left = node1;
        node3.right = node4;
        node5.right = node8;
        node8.left = node6;
        node6.right = node7;
        node8.right = node9;
        node9.right = node10;
    }


    @Test
    public void test() {
        Random random = new Random(1);
        for(int i = 0; i < 100; i++) {
            TreeNode p = treeNodes[random.nextInt(treeNodes.length)];
            TreeNode q = treeNodes[random.nextInt(treeNodes.length)];
            TreeNode p1 = new LowestCommonAncestor().lowestCommonAncestorBST(node5, p, q);
            TreeNode p2 = new LowestCommonAncestor().lowestCommonAncestor(node5, p,q);
            Assert.assertEquals(p1, p2, "p="+ p.val + " q="+ q.val);
        }


    }
}
