package org.xuan;

import org.testng.Assert;
import org.testng.annotations.Test;

/**
 * Created by xzhou2 on 4/18/16.
 */
public class CombinationIIITest {
    @Test
    public void test() {
        int n = 9, k = 3;
        Assert.assertEquals(new CombinationIII().combinationSum3(k, n).size(), 3);
    }
}
