package org.xuan;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

/**
 * Created by xzhou2 on 4/6/16.
 */
public class RotateArrayTest {
    @DataProvider(name = "data")
    public Object[][] data(){
        return new Object[][]{
                {new int[]{1,2,3,4,5}, 3}
        };
    }

    @Test(dataProvider = "data")
    public void test(int[] nums, int k) {
        new RotateArray().rotate(nums, k);
    }
 }
