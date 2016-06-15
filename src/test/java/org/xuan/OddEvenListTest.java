package org.xuan;

import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import util.ListBuilder;
import util.ListNode;

/**
 * Created by xzhou2 on 6/13/16.
 */
public class OddEvenListTest {

    @DataProvider(name = "data")
    public Object[][] data() {
        return new Object[][] {
                {new int[]{}},
                {new int[]{1}},
                {new int[]{1,2}},
                {new int[]{1,2,3}},
                {new int[]{1,2,3,4}},
                {new int[]{1,2,3,4,5}},
                {new int[]{1,2,3,4,5,6}}

        };
    }


    @Test(dataProvider = "data")
    public void test(int[] nums) {
        ListNode node = ListBuilder.buildFromArray(nums);
        new OddEvenList().oddEvenList(node);
        Assert.assertTrue(true);
    }
}
