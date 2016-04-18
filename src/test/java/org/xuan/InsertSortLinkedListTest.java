package org.xuan;

import junit.framework.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import util.ListBuilder;
import util.ListNode;

import java.util.Arrays;
import java.util.Collections;

/**
 * Created by xzhou2 on 3/29/16.
 */
public class InsertSortLinkedListTest {
    @DataProvider(name = "data")
    public Object[][] data() {
        return new Object[][] {
                {new int[]{1}}, {new int[]{3,1,2}}, {new int[]{3,1,3}}, {new int[]{1,2,3,4,5,6,7,4,3}}
        };
    }

    @Test(dataProvider = "data")
    public void test(int[] input) {
            Collections.shuffle(Arrays.asList(input));
            ListNode head = ListBuilder.buildFromArray(input);
            ListNode result = new InsertSortLinkedList().insertionSortList(head);
            int curr = result.val;
            while(result != null) {
                if (result.val < curr) {
                    Assert.fail();
                }
                else {
                    curr = result.val;
                    result = result.next;
                }
            }
    }
}
