package org.xuan;

import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.Random;

/**
 * Created by xzhou2 on 5/19/16.
 */
public class MoveZerosTest {

    @Test
    public void test() {
        int len =30;
        /*Random random = new Random(1);
        int[] num = new int[len];
        int val = 0;
        for(int i = 0; i < len; i++) {
            if (random.nextBoolean()) {
                num[i] = 0;
            }
            else {
                num[i] = val++;
            }
        }*/
        int[] num = new int[]{0,1};
        new MoveZeros().moveZeroes(num);
        Assert.assertTrue(num[len-1] == 0);
    }
}
