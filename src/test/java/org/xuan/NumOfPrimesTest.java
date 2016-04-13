package org.xuan;

import org.testng.Assert;
import org.testng.annotations.Test;

/**
 * Created by xzhou2 on 4/11/16.
 */
public class NumOfPrimesTest {
    @Test
    public void test() {
        Assert.assertEquals(new NumOfPrimes().countPrimes(9), 4);
    }
}
