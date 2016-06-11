package org.xuan;

import org.testng.Assert;
import org.testng.annotations.Test;

/**
 * Created by xzhou2 on 6/5/16.
 */
public class CoinChangeTest {
    @Test
    public void test() {
        Assert.assertEquals(new CoinChange().coinChange(new int[]{399,313,460,317,401,173,116,17,121}, 7335), 3);
    }
}
