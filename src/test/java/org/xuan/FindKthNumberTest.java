package org.xuan;

import junit.framework.Assert;
import org.testng.annotations.Test;
import util.FindKthNumber;

import java.util.Arrays;
import java.util.Random;

/**
 * Created by xzhou2 on 6/6/16.
 */
public class FindKthNumberTest {
    @Test
    public void test() {
        int n = 10000;
        int[] value = new int[n];
        Integer[] copy = new Integer[n];
        long t = System.currentTimeMillis();
        for(int j = 0; j < 100; j++) {
            Random random = new Random();

            for(int i = 0; i < n; i++) {
                int v = random.nextInt(n);
                value[i] = v;
                copy[i] = v;
            }
            Arrays.sort(copy, (p, q) -> (q - p));
            int k = FindKthNumber.findKthNumber(value, (n - 1) /2);
            if (k != copy[(n - 1) /2]) {
                Assert.fail("seed=" + t);
            }
        }


    }
}
