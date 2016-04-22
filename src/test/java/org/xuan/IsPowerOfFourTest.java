package org.xuan;

import org.testng.Assert;
import org.testng.annotations.Test;

/**
 * Created by xzhou2 on 4/20/16.
 */
public class IsPowerOfFourTest {

    @Test
    public void test() {
        int n =1024;
        for(int i = 0; i < n; i++) {

            Assert.assertEquals(new IsPowerOfFour().isPowerOfFour(i), new IsPowerOfFour().isPowerOfFourI(i));
        }
    }
}
