package org.xuan;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import java.util.List;

/**
 * Created by xzhou2 on 4/25/16.
 */
public class SkyLineTest {
    @DataProvider(name = "data")
    public Object[][] data() {
        return new Object[][] {
                {new int[][]{new int[]{0,2,3}, new int[]{2,5,3}}}
        };
    }

    @Test(dataProvider = "data")
    public void test(int[][] input) {
        List<int[]> result = new SkyLine().getSkyline(input);
    }
}
