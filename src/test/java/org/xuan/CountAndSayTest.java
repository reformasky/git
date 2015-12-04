package org.xuan;

import org.testng.Assert;
import org.testng.annotations.Test;

/**
 * Created by xuan on 2015/12/1.
 */
public class CountAndSayTest {

    @Test
    public void test() {
        String result = new CountAndSay().countAndSay(2);
        Assert.assertEquals(result,"11");
    }
}
