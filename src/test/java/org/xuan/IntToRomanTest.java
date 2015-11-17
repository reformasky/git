package org.xuan;

import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

/**
 * Created by xuan on 2015/11/12.
 */
public class IntToRomanTest {
    @DataProvider(name = "data")
    public Object[][] data() {
        return new Object[][] {
                {1, "I"}, {3, "III"}, {4, "IV"}, {5, "V"}, {6, "VI"}, {8, "VIII"}, {9, "IX"}, {10, "X"}, {11, "XI"},
                {14, "XIV"}, {15,"XV"}, {16, "XVI"}, {39, "XXXIX"}, {40, "XL"}, {50, "L"}, {75, "LXXV"},
                {3999, "MMMCMXCIX"}
        };
    }

    @Test(dataProvider ="data")
    public void test(int num, String expectedResult) {
        String actualResult = new IntToRoman().intToRoman(num);
        Assert.assertEquals(actualResult, expectedResult);
    }

    @Test(dataProvider = "data")
    public void testReverse(int expectedResult, String input) {
        int actualResult = new RomanToInt().romanToInt(input);
        Assert.assertEquals(actualResult, expectedResult);
    }
}
