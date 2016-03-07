package org.xuan;

import org.testng.Assert;
import org.testng.annotations.Test;

/**
 * Created by xuan on 2016/3/4.
 */
public class BuyStockIIITest {

    @Test
    public void test() {
        Assert.assertEquals(new BuyStockIII().maxProfit_O_N(new int[]{6,1,3,2,4,7}), 7);
    }
}
