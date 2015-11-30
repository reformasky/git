package org.xuan;

import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

/**
 * Created by xuan on 2015/11/28.
 */
public class NextPermutationTest {
    @Test(dataProvider = "data")
    public void test(int[] input, int[] output) {
        new NextPermutation().nextPermutation(input);
        for(int i = 0; i < input.length;i++) {
            Assert.assertEquals(input[i], output[i]);
        }
    }

    @DataProvider(name = "data")
    public Object[][] data() {
        return new Object[][] {
                {
                        new int[] {1,1,2,3,4}, new int[]{1,1,2,4,3}
                },
                {
                        new int[]{1,1,2,4,3}, new int[]{1,1,3,2,4}
                },
                {
                        new int[]{1,1,3,2,4}, new int[]{1,1,3,4,2}
                },
                {
                        new int[]{1,1,3,4,2}, new int[]{1,1,4,2,3}
                },
                {
                        new int[]{1,1,4,3,2}, new int[] {1,2,1,3,4}
                }
        };
    }
}
