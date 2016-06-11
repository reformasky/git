package org.xuan;

import org.testng.Assert;
import org.testng.annotations.Test;

/**
 * Created by xzhou2 on 5/31/16.
 */
public class SuperUglyNumberTest {

    @Test
    public void test() {
        int[] primers = new int[] {2, 7, 13, 19};
        int n = 12;
        int r = new SuperUglyNumber().nthSuperUglyNumber(n, primers);
        Assert.assertEquals(r, 32);
    }
}
