package org.xuan;

import org.testng.Assert;
import org.testng.annotations.Test;
import util.VerifyPreorderBT;

/**
 * Created by xzhou2 on 6/9/16.
 */
public class VerifyPreorderBTTest {
    @Test
    public void test() {
        String s = "1,#,2,#,3,#,4,#,#";
        Assert.assertEquals(new VerifyPreorderBT().isValidSerialization(s), true);

    }
}
