package org.xuan;

import junit.framework.Assert;
import org.testng.annotations.Test;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by xzhou2 on 5/24/16.
 */
public class AdditiveNumberTest {
    @Test
    public void test() {
        List<Integer>[] graph = (ArrayList[])(new ArrayList[1]);

        Assert.assertTrue(new AdditiveNumber().isAdditiveNumber("211738"));
    }


}
