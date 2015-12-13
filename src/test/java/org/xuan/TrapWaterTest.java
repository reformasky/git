package org.xuan;

import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

/**
 * Created by xuan on 2015/12/7.
 */
public class TrapWaterTest {
    @DataProvider(name = "data")
    public Object[][] data() {
        return new Object[][] {
                {new int[]{0,1,0,2,1,0,1,3,2,1,2,1}, 6},{new int[]{1974, 13905, 1543, 18921, 18430, 5233, 15546, 2980, 13751, 3170, 18105, 17944, 6861, 17765, 17475, 5107, 16123, 7880, 11763, 5772, 12644, 12865, 4668, 13838, 18863, 18580, 7616, 6095, 9267, 1372, 14133, 2158, 6850, 8102, 9883, 5508, 5006, 3010, 4008, 16174, 1968, 184, 9135, 8297, 11522, 1351, 2399, 14275, 789, 8914}, 0}
        };
    }

    @Test(dataProvider = "data")
    public void test(int[] height, int expectedResult) {
        int actualResult = new TrapWater().trap(height);
        Assert.assertEquals(actualResult,expectedResult);
    }
}
