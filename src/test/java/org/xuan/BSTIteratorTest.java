package org.xuan;

import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import org.xuan.BSTIterator;
import util.TreeNode;

import java.util.ArrayList;

/**
 * Created by xzhou2 on 4/5/16.
 */
public class BSTIteratorTest {
    @DataProvider(name = "data")
    public Object[][] data() {
        return new Object[][] {
/*
                {new int[]{1}}, {new int[]{1,2}}, {new int[]{1,2,3,4,5}},
*/
                {new int[]{9,4,3,1,8,10,15}}
        };
    }

    @Test(dataProvider = "data")
    public void testBalanced(int[] input) {
        TreeNode treeNode = new TreeNode(input[0]);
        for(int i = 1; i < input.length; i++) {
            treeNode = TreeNode.addNode(treeNode, input[i]);
        }
        BSTIterator iterator = new BSTIterator(treeNode);
        ArrayList<Integer> res = new ArrayList<>();
        while(iterator.hasNext()){
            res.add(iterator.next());
        }
        for(int i = 0; i < res.size() - 1; i++) {
            if (res.get(i) > res.get(i+1)) {
                Assert.fail();
            }
        }
    }
}
