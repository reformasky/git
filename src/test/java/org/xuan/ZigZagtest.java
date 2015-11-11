package org.xuan;

import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

/**
 * Created by xuan on 2015/11/10.
 */
public class ZigZagtest {
    @DataProvider(name = "data")
    public Object[][] data() {
        return new Object[][] {
                {
                        "PAYPALISHIRING", 3,"PAHNAPLSIIGYIR"
                },
                {
                        "ABCD", 3, "ABDC"

                }
        };
    }

    @Test(dataProvider = "data")
    public void test(String input, Integer numOfRows, String expectedOutput) {
        String acturalOutput = new ZigZag().convert(input,numOfRows);
        Assert.assertEquals(acturalOutput, expectedOutput);
    }

}
