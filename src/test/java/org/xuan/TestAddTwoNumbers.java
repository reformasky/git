package org.xuan;

import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import util.ListBuilder;
import util.ListNode;

/**
 * Created by xuan on 2015/11/8.
 */
public class TestAddTwoNumbers {
    @DataProvider(name = "data")
    public Object[][] data() {
        return new Object[][] {
                {
                        null, null, null
                },
                {
                        new ListBuilder(1).build(), null, new ListBuilder(1).build()
                },
                {
                        new ListBuilder(9).add(8).build(), new ListBuilder(1).add(2).add(3).build(),
                        new ListBuilder(0).add(1).add(4).build()
                },
                {
                        new ListBuilder(9).add(8).add(7).build(), new ListBuilder(1).add(2).add(3).build(),
                        new ListBuilder(0).add(1).add(1).add(1).build()
                }
        };
    }

    @Test(dataProvider = "data")
    public void test(ListNode l1, ListNode l2, ListNode result) {
        ListNode actural = new AddTwoNumbers().addTwoNumbers(l1,l2);
        if (result == null) {
            Assert.assertNull(actural);
        }
        else {
            while (actural != null) {
                Assert.assertEquals(actural.val, result.val);
                actural = actural.next;
                result = result.next;
            }
            Assert.assertNull(result);
        }
    }

}
