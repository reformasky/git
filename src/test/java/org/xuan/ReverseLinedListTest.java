package org.xuan;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import org.xuan.util.ListBuilder;
import util.ListNode;

/**
 * Created by xzhou2 on 3/27/16.
 */
public class ReverseLinedListTest {
    @DataProvider(name = "data")
    public Object[][] data() {
        return new Object[][] {
                {new int[]{1,2}, new int[]{2,1}},
                {new int[]{1,2,3}, new int[]{3,2,1}},
                {new int[]{1,2,3,4}, new int[]{4,3,2,1}}
        };
    }

    @Test(dataProvider = "data")
    public void test(int[] input, int[] output) {
        ListNode listNode = ListBuilder.buildFromArray(input);
        ListNode result = new ReverseLinkedList().reverseList(listNode);
    }
}
