package org.xuan;

import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

/**
 * Created by xzhou2 on 6/1/16.
 */
public class RemoveDuplicateLettersTest {
    @DataProvider(name = "data")
    public Object[][] data() {
        return new Object[][] {
                {
                        "cbcab","bca"
                }
        };
    }


    @Test(dataProvider = "data")
    public void test(String input, String output) {
        Assert.assertEquals(new RemoveDuplicatedLetters().removeDuplicateLetters(input), output);
    }
}
