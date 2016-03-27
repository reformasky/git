package org.xuan;

import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Random;

/**
 * Created by xzhou2 on 3/27/16.
 */
public class SingleNumberIITest {
    Random random = new Random(1);
    @Test
    public void test() {
        int odd = 1024;
        int length = 10;
        int[] values = new int[length * 3 + 1];
        for(int i = 0; i < length * 3; i++) {
            values[i] = i / 3;
        }
        values[length * 3] = odd;
        Assert.assertEquals(new SingleNumberII().singleNumber(values), odd);

    }
}

