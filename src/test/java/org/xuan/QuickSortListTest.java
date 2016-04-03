package org.xuan;

import junit.framework.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import org.xuan.util.ListBuilder;
import util.ListNode;

import java.util.Random;

/**
 * Created by xzhou2 on 3/31/16.
 */
public class QuickSortListTest {
    int size = 1000;
    @Test
    public void test() {

        Random random = new Random(1);
        int[] ints = new int[size];
        for(int i = 0; i < size; i++) {
            ints[i] = random.nextInt(size);
        }
        ListNode listNode = ListBuilder.buildFromArray(ints);

        ListNode result = new QuickSortList().sortList(listNode);
        String[] strings = " the sky is blue".split(" ");
        assertSorted(result);
    }

    private void assertSorted(ListNode result) {
        int i = 1;
        int pre = result.val;
        result = result.next;
        while (result != null) {
            i++;
            int curr = result.val;
            if (curr< pre) {
                Assert.fail();
            }
            result = result.next;
        }
        Assert.assertEquals(i, size);
    }
}
