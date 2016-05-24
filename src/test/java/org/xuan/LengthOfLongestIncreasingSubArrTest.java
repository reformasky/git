package org.xuan;

import org.testng.annotations.Test;

/**
 * Created by xzhou2 on 5/22/16.
 */
public class LengthOfLongestIncreasingSubArrTest {
    @Test
    public void test() {
        int i = new LengthOfLongestIncreasingSubArray().lengthOfLIS(new int[]{10,9,2,5,3,7,101,18});
    }
}
