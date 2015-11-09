package org.xuan;

import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;


/**
 * Created by xuan on 2015/11/8.
 */
public class TestLongestSubStringWithNoDuplicate {
    @DataProvider(name = "data")
    public Object[][] data() {
        return new Object[][] {
                {
                        null, 0
                },
                {
                        "", 0
                },
                {
                        "a", 1
                },
                {
                        "aa", 1
                },
                {
                        "abcabcdab",4
                },
                {
                        "ababcdabcdeabcdefg", 7
                },
                {
                        "ABBA", 2
                },
                {
                        "dvdf", 3
                }
        };
    }

    @Test(dataProvider = "data")
    public void test(String input, Integer expectedResult) {
        Integer acturalResult = new LongestSubStringWithNoDuplicate().lengthOfLongestSubstring(input);
        Assert.assertEquals(acturalResult, expectedResult);
    }
}
