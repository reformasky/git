package org.xuan;

import org.testng.Assert;
import org.testng.annotations.Test;

/**
 * Created by xzhou2 on 5/18/16.
 */
public class PerfectSquareTest {
    @Test
    public void test() {
        Assert.assertEquals(new PerfectSquare().numSquares(7), 4);
    }
}
