package org.xuan;

import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

/**
 * Created by xuan on 2015/12/19.
 */
public class EditDistanceTest {
    @DataProvider(name = "data")
    public Object[][] data(){
        return new Object[][] {
                {"horse", "ros", 3}
        };
    }

    @Test(dataProvider = "data")
    public void test(String s1, String s2, int expectedResult) {
        int actualResult = new EditDistance().minDistance(s1, s2);
        Assert.assertEquals(actualResult, expectedResult);
    }
}
