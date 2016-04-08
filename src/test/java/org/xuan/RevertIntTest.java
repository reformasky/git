package org.xuan;

import org.testng.Assert;
import org.testng.annotations.Test;

/**
 * Created by xzhou2 on 4/7/16.
 */
public class RevertIntTest {
    @Test
    public void test() {
        Assert.assertEquals(new RevertInteger().reverseBits(1), Integer.MIN_VALUE);

    }
}
