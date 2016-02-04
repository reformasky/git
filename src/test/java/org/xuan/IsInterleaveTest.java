package org.xuan;

import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

/**
 * Created by xuan on 2016/2/2.
 */
public class IsInterleaveTest {
    @DataProvider(name = "data")
    public Object[][] data() {
        return new Object[][] {
                {"aabcc", "dbbca", "aadbbcbcac", true}
        };
    }

    @Test(dataProvider = "data")
    public void test(String s1, String s2, String s3, boolean expectedResult) {
        Assert.assertEquals(new IsInterleaved().isInterleave(s1, s2, s3), expectedResult);
    }
}
