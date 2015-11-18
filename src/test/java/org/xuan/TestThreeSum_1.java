package org.xuan;

import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by xuan on 2015/11/16.
 */
public class TestThreeSum_1 {
    @DataProvider(name = "data")
    public Object[][] data() {
        return new Object[][] {
                {
                        null,new int[][]{}
                },
                {
                        new int[] {0,0,0}, new int[][]{{0,0,0}}
                },
                {
                       new int[] {-1, 0, 1, 2, -1, -4}, new int[][] {{-1, 0, 1},{-1, -1, 2}}
                }

        };
    }

    @Test(dataProvider = "data")
    public void test(int[] nums, int[][] result) {
        List<List<Integer>> actualResult = new ThreeSum_1().threeSum(nums);
        Assert.assertEquals(actualResult.size(), result.length);
    }
}
