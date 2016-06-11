package org.xuan;

import org.testng.annotations.Test;

import java.util.Random;

/**
 * Created by xzhou2 on 6/8/16.
 */
public class CountRangeSumTest {
    @Test
    public void test() {
        int n = 80;
        int low = -2, high = 2;
        long seed = System.currentTimeMillis();
        Random random = new Random(seed);
        System.out.println("seed=" + seed);
        int[] val = new int[n];
        for(int i = 0; i< n; i++) {
            val[i] = n / 2 - random.nextInt(n);
        }
        StringBuilder sb = new StringBuilder();

        sb.append('[');
        for(int i : val) {
            sb.append(i + ",");
        }
        sb.delete(sb.length() - 1, sb.length());
        sb.append(']');
        sb.append("\n" + low + "\n" + high);
        System.out.println(sb.toString());
        System.out.println(new CountRangeSum().countRangeSum(val, low, high));

    }
}
