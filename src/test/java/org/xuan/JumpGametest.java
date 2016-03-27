package org.xuan;

import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

/**
 * Created by xuan on 2015/12/13.
 */
public class JumpGametest {
    @DataProvider(name = "data")
    public Object[][] data() {
        return new Object[][] {
                {new int[]{3,2,1,0,4}, false}, {new int[]{3,2,1,1,4}, true}
        };
    }

    @Test(dataProvider = "data")
    public void test(int[] data, boolean expectedResult) {
        Assert.assertEquals(new JumpGame().canJump(data), expectedResult);
    }
}
