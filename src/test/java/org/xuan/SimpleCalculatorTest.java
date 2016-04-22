package org.xuan;

import org.testng.Assert;
import org.testng.annotations.Test;

/**
 * Created by xzhou2 on 4/20/16.
 */
public class SimpleCalculatorTest {
    @Test
    public void test() {
        int num  = (12) -(( 21 + 32) - 5 *(41+ 57)   /3 - 7 * (62-700))/5;
        String s = "(12) -(( 21 + 32) - 5 *(41+ 57)   /3 - 7 * (62-700))/5";
/*        int num = (1) - (2) - (3);
        String s = "(1) - (2) - (3)";*/
        Assert.assertEquals(new SimpleCalculatorIII().calculate(s) , num);
    }
}
