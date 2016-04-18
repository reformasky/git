package org.xuan;

import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

/**
 * Created by xzhou2 on 4/13/16.
 */
public class MinSubArrLengthTest {
    @DataProvider(name = "data")
    public Object[][] data(){
        return new Object[][] {
                {new int[]{1,2,4,3,1}, 5, 2}
        };
    }

    @Test(dataProvider = "data")
    public void test(int[] nums, int s, int r) {
        Assert.assertEquals(new MinSubArrLength().minSubArrayLen(s, nums), r);
    }
}
