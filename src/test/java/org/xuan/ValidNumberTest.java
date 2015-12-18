package org.xuan;

import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

/**
 * Created by xuan on 2015/12/17.
 */
public class ValidNumberTest {
    @DataProvider(name = "data")
    public Object[][] data() {
        return new Object[][] {
/*                {" ", false}, {"1", true},{" -1 ", true}, {" +1 ", true}, {"- 1", false}, {" -.5", true}, {"1.", true }, {"1.1e1", true},
                {"1.1e", false}, {"1.1.1", false}, {"1e1.1", false}, {"1.e", false}, {"1. 1", false}, {"-1.e1", true},
                {" + ", false}, {" - 1", false},
                {"1e+11", true} ,{".", false},*/
                {"1 ", true}
        };
    }

    @Test(dataProvider = "data")
    public void test(String input, boolean expectedResult) {
        Assert.assertEquals(new ValidNumber().isNumber(input), expectedResult);
    }
}
