package org.xuan;

import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import util.ListNode;

import java.util.List;

/**
 * Created by xuan on 2016/3/20.
 */
public class PalindromePartitionTest {
    @DataProvider(name = "data")
    public Object[][] data() {
        return new Object[][] {
/*                {
                        "aab", 2
                },
                {
                        "a", 1
                },
                {
                        "aa", 2
                },*/
                {
                        "aabaa", 6
                }
        };
    }

    @Test(dataProvider = "data")
    public void test(String input, int size) {
        List<List<String>> result = new PalindromePartition().partition(input);
        Assert.assertEquals(result.size(), size);
    }
}
