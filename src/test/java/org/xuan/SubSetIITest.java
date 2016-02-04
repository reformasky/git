package org.xuan;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import java.util.List;

/**
 * Created by xuan on 2016/1/26.
 */
public class SubSetIITest {
    @DataProvider(name = "data")
    public Object[][] data() {
        return new Object[][] {
                {new int[]{1,1,2,2}}
        };
    }

    @Test(dataProvider = "data")
    public void test(int[] input) {
        List<List<Integer>> result = new SubSetII().subsetsWithDup(input);
    }
}
