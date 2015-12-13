package org.xuan;

import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

/**
 * Created by xuan on 2015/12/8.
 */
public class StringMultiplyTest {
    @DataProvider(name = "data")
    public Object[][] data( ) {
        return new Object[][] {
/*                {"21","24", "504"},
                {"12","240", "2880"},*/
                {"15552", "2345","36469440"}
        };
    }

    @Test(dataProvider = "data")
    public void test(String s1, String s2, String expectedResult ) {
        String actualResult = new StringMultiply().multiply(s1, s2);
        Assert.assertEquals(actualResult, expectedResult);
    }
}
