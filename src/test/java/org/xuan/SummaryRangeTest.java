package org.xuan;

import junit.framework.Assert;
import org.testng.annotations.Test;

/**
 * Created by xzhou2 on 6/12/16.
 */
public class SummaryRangeTest {
    @Test
    public void test() {
        int[] vals = new int[]{1, 10,5,4,7,8,6, 9};
        SummaryRanges ranges = new SummaryRanges();
        for(int val: vals) {
            ranges.addNum(val);
        }
        Assert.assertNotNull(ranges);
    }

}
