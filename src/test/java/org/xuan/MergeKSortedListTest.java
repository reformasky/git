package org.xuan;

import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import util.ListBuilder;
import util.ListNode;

/**
 * Created by xuan on 2015/11/20.
 */
public class MergeKSortedListTest {

    @DataProvider(name = "data")
    public Object[][] data() {
        return new Object[][] {
                {
                       ListBuilder.buildFromArray(null),
                       new int[][]{ null,null, null, null}
                },
                {
                        ListBuilder.buildFromArray(new int[]{1,1,1,2,2,2,3,3,3}),
                        new int[][] {new int[]{1,2,3}, new int[]{1,2,3}, new int[]{1,2,3}}
                },
                {
                        ListBuilder.buildFromArray(new int[]{1,1,2,2,3,3,4}),
                        new int[][] {new int[]{1,2,3}, null, new int[]{1,2,3,4}}
                },
                {
                        ListBuilder.buildFromArray(new int[]{1,1,2,2,3,3,47}),
                        new int[][] {new int[]{1,2,3}, null, new int[]{1,2,3,47}, new int[]{}}
                }
        };
    }

    @Test(dataProvider = "data")
    public void test(ListNode expectedResult, int[][] arrays) {
        ListNode[] inputs = new ListNode[arrays.length];
        for(int i = 0; i < arrays.length; i++){
            inputs[i] = ListBuilder.buildFromArray(arrays[i]);
        }
        ListNode actualResult = new MergeKSortedList().mergeKLists(inputs);
        while(actualResult != null) {
            if (actualResult.val != expectedResult.val) {
                Assert.fail();
            }
            actualResult = actualResult.next;
            expectedResult = expectedResult.next;
        }
    }
}
