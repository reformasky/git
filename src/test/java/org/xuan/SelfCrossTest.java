package org.xuan;

import org.testng.Assert;
import org.testng.annotations.Test;

/**
 * Created by xzhou2 on 6/10/16.
 */
public class SelfCrossTest {
    @Test
    public void test() {
        Assert.assertEquals(new SelfCross().isSelfCrossing(new int[]{3,3,4,2,2}),false);
    }

}
