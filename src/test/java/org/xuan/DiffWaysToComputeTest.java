package org.xuan;

import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

/**
 * Created by xzhou2 on 5/16/16.
 */
public class DiffWaysToComputeTest {
    @DataProvider(name = "data")
    public Object[][] data() {
        return new Object[][] {
                {"", new int[]{}},
                {"12", new int[]{12}},
                {"12+34", new int[]{46}},
                {"1-2-3", new int[]{-4, 2}},
                {"2*3-4*5", new int[]{-34, -14, -10, -10, 10}}
        };
    }

    @Test(dataProvider = "data")
    public void test(String s, int[] exp) {
        List<Integer> res = new DiffWaysToCompute().diffWaysToCompute(s);
        Collections.sort(res);
        Arrays.sort(exp);
        Assert.assertEquals(res.size(), exp.length);
        for(int i =0; i < exp.length; i++) {
            Assert.assertEquals(exp[i], (int)res.get(i));
        }
    }
}
