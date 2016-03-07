package org.xuan;

import org.testng.Assert;
import org.testng.annotations.Test;

/**
 * Created by xuan on 2016/3/6.
 */
public class IsPanlindromeTest {
    @Test
    public void test() {
        Assert.assertTrue(new IsPalindrome().isPalindrome("0P"));
    }
}
