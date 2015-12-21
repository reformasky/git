package org.xuan;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import java.util.List;

/**
 * Created by xuan on 2015/12/18.
 */
public class TextJustificationTest {
    @DataProvider(name = "data")
    public Object[][] data() {
        return new Object[][] {
                {new String[]{"1","1", "", "123"},5}
        };
    }
    @Test(dataProvider = "data")
    public void test(String[] words, int max) {
        List<String> result = new TextJustification().fullJustify(words, max);
    }
}
