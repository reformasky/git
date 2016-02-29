package org.xuan;

import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

/**
 * Created by xuan on 2016/2/28.
 */
public class DistSubsequenceTest {
    @DataProvider(name = "data")
    public Object[][] data() {
        return new Object[][] {
                {
                        "ababb", "ab", 5
                },
                {
                        "bbb", "bb", 3
                }
        };
    }

    @Test(dataProvider = "data")
    public void test(String s, String t, int result) {
        Assert.assertEquals(new DistSubSequences().numDistinct(s,t), result);
    }
}
