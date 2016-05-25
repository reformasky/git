package org.xuan;

import junit.framework.Assert;
import org.testng.annotations.Test;

/**
 * Created by xzhou2 on 5/24/16.
 */
public class AdditiveNumberTest {
    @Test
    public void test() {
        Assert.assertTrue(new AdditiveNumber().isAdditiveNumber("211738"));
    }
}
