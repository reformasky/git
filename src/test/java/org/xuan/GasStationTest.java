package org.xuan;

import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

/**
 * Created by xuan on 2016/3/24.
 */
public class GasStationTest {
    @DataProvider(name = "data")
    public Object[][] data() {
        return new Object[][] {
                {
                        new int[]{6,0,1,3,2}, new int[]{4,5,2,5,5}, 3
                }
        };
    }

    @Test(dataProvider = "data")
    public void test(final int[] gas, final int[] cost, final int result) {
        Assert.assertEquals(new GasStation().canCompleteCircuit(gas, cost), result);
    }
}
