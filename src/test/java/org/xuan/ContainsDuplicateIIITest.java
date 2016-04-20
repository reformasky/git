package org.xuan;

import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.Random;

/**
 * Created by xzhou2 on 4/18/16.
 */
public class ContainsDuplicateIIITest {
    @Test
    public void test() {
        Random random = new Random(2);
        int size = 10;
        int k = 2;
        int[] nums = new int[]{1,9,3,16,21,2};
        /*for(int i = 0; i < size; i++) {
            nums[i] = random.nextInt(30);
        }*/
        int t = 2;
        Assert.assertEquals(new ContainsDuplicateIII().containsNearbyAlmostDuplicate(nums, k, t),true);
    }
}
