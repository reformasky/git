package org.xuan;

import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import util.ListBuilder;
import util.ListNode;

/**
 * Created by xzhou2 on 4/22/16.
 */
public class IsPalindromeListTest {
    @DataProvider(name = "data")
    public Object[][] data(){
        return new Object[][] {
                {new int[]{1,2,3,3,2,1}, true},
                {new int[]{1,2,3,4,3,2,1}, true},
                {new int[]{1,2,3,4,4,2,1}, false},
                {new int[]{1}, true},
                {new int[]{1,1}, true},
                {new int[]{1,2}, false}
        };
    }

    @Test(dataProvider = "data")
    public void test(int[] ints, boolean result) {
        ListNode node = ListBuilder.buildFromArray(ints);
        Assert.assertEquals(new IsPalindromeList().isPalindrome(node), result);
        Assert.assertNotNull(node);
    }
}
