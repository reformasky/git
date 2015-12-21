package org.xuan;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

/**
 * Created by xuan on 2015/12/20.
 */
public class MinimalWindowTest {
    @DataProvider(name = "data")
    public Object[][] data() {
        return new Object[][] {
                {"ababaaab","aaba"}
        };
    }

    @Test(dataProvider = "data")
    public void test(String s, String t) {
        String result = new MinimalWindow().minWindow(s,t);
    }
}
