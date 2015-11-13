package org.xuan;

import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

/**
 * Created by xuan on 2015/11/12.
 */
public class TestWater {
    @DataProvider(name = "data")
    public Object[][] data() {
        return new Object[][] {
                {
                        new int[] {10, 8, 6}, 12
                } ,
                {
                        new int[] {13, 14, 6, }, 13
                },
                {
                        new int[] {1, 14, 15, 2 },  14
                },
                {
                        new int[] {1, 14, 15, 8}, 16
                },
                {
                        new int[] {1, 100, 8, 10, 21, 2}, 63
                }
        };
    }

    @Test(dataProvider = "data")
    public void test(int[] height, int expectedResult)
    {
        int acturalReslut = new Water().maxArea(height);
        Assert.assertEquals(acturalReslut, expectedResult);
    }
}
