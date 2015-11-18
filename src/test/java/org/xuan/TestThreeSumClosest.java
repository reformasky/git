package org.xuan;

import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

/**
 * Created by xuan on 2015/11/17.
 */
public class TestThreeSumClosest {
    @DataProvider(name = "data")
    public Object[][] data() {
        return new Object[][] {
              /*  {new int[] {1,4,8,10, 13}, 13, 13 },
                {new int[] {1,4,8,10, 13}, 15, 15 },*/
/*
                {new int[] {1,4,8,10, 13}, 12, 13 },
*/
                {new int[] {1,4,8,10, 13}, 17, 18 },
               /* {new int[] {1,4,8,10, 13}, 19, 19 },
                {new int[] {1,4,8,10, 13}, 21, 22 },*/
        };
    }

    @Test(dataProvider = "data")
    public void test(int[] nums, int target, int sum) {
        int actualSum = new ThreeSumClosest().threeSumClosest(nums,target);
        Assert.assertEquals(actualSum, sum);
    }
}
