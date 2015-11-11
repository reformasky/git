package org.xuan;

import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

/**
 * Created by xuan on 2015/11/9.
 */
public class LongestPalindromicSubStringTest {
    @DataProvider(name = "data")
    public Object[][] data() {
        return new Object[][] {
                {null, null}, {"", null},
                {"abcde", "a"},
                {"aab", "aa"},
                {"aaa", "aaa"},
                {"abccbad", "abccba"},
                {"abbaaab", "baaab"}
        };
    }

    @Test(dataProvider = "data")
    public void test(String s, String result) {
        String acturalResult = new LongestPalindromicSubString().longestPalindrome_solution1(s);
        Assert.assertEquals(acturalResult, result);
    }
}
