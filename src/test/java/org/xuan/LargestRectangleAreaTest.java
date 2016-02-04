package org.xuan;

import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

/**
 * Created by xuan on 2016/1/13.
 */
public class LargestRectangleAreaTest {
    @DataProvider(name="data")
    public Object[][] data() {
        return new Object[][] {
             /*   {
                        new int[]{}, 0
                },
                {
                        new int[]{1}, 1
                },*/
                {
                        new int[] {2,1,5,6,2,3}, 10
                }

        };
    }

    @Test(dataProvider = "data")
    public void test(int[] height, int expectedResult) {
        int actualResult = new LargestRectangleArea().largestRectangleArea(height);
        Assert.assertEquals(actualResult, expectedResult);
    }
}
