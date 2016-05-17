package org.xuan;

import org.testng.Assert;
import org.testng.annotations.Test;
import util.TreeCounterNode;

import java.util.Random;

/**
 * Created by xzhou2 on 4/26/16.
 */
public class KthSmallestBSTTest {
    @Test
    public void test() {
        int n = 1000;
        int[] vals = new int[n];
        for(int i = 0; i < n; i++) {
            vals[i] = i + 1;
        }
        Random random = new Random(10);
        TreeCounterNode root = TreeCounterNode.constructBST(vals);
        boolean fail = false;
        int index = 0;
        for(int j = 0; j < 100; j++) {
            int k = random.nextInt(n) + 1;
            int val = new KthSmallestInBST().kthSmallest(root, k);
            if (val != k) {
                fail = true;
                index = k;
            }
        }

        if (fail) {
            Assert.fail("index=" + index);
        }

    }
}
