package org.xuan;

import org.testng.Assert;
import org.testng.annotations.Test;

/**
 * Created by xzhou2 on 5/23/16.
 */
public class NumArrayTest {
    @Test
    public void test() {
        int[] nums =new int[]{-2, 0, 3, -5, 2, -1};
        NumArray numArray = new NumArray(nums);
        Assert.assertEquals(numArray.sumRange(0, 2), 1);
        Assert.assertEquals(numArray.sumRange(2, 5), -1);
        Assert.assertEquals(numArray.sumRange(0, 5), -3);
    }
}
