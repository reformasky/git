package org.xuan;

import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;

/**
 * Created by xzhou2 on 4/15/16.
 */
public class FindKthLargestTest {
    @Test
    public void testInSeq() {
        int n = 100;
        int k = 40;
        int[] nums = new int[n];
        for(int i = 0; i < n; i++) {
            nums[i] = n - k;
        }
        //Collections.shuffle(Arrays.asList(nums));
        Assert.assertEquals(new FindKthLargest().findKthLargest(nums, k), n - k);
    }
}
