package org.xuan;

import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

/**
 * Created by xuan on 2015/12/11.
 */
public class JumpGame_2Test {
    @DataProvider(name = "data")
    public Object[][] data() {
        return new Object[][] {
                {new int[]{1,2,3}, 2}
        };
    }

    @Test(dataProvider = "data")
    public void test(int[] nums, int expectedResults) {
        int actualResult = new JumpGame_2().jump(nums);
        Assert.assertEquals(actualResult,expectedResults);
    }
}
