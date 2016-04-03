package org.xuan;

import org.testng.Assert;
import org.testng.annotations.Test;

/**
 * Created by xzhou2 on 4/1/16.
 */
public class MaxProdSubArrayTest {
    @Test
    public void test() {
        Assert.assertEquals(new MaxProdSubArray().maxProduct(new int[]{-1,3,-2, -9, 4,4}), 864);
    }
}
