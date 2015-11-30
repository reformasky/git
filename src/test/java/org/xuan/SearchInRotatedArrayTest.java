package org.xuan;

import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

/**
 * Created by xuan on 2015/11/29.
 */
public class SearchInRotatedArrayTest {
    @DataProvider(name = "data")
    public Object[][] data() {
/*        final int[] arr1 = new int[] {0,1,2,3,4,5};*/
        final int[] arr21 = new int[] {0,0,1,1,2,2,3,3,4,4};
        final int[] arr1 = new int[] {0,0,0,1,1,1,2,2,2,3,3,3,4,4,4};
        Object[][] result = new Object[arr1.length - 1][2];
        for(int i = 1; i < arr1.length; i++) {
            result[i - 1] = new Object[] {
                    rotate(arr1, i), new Integer(arr1.length - i)
            };
        }
        return result;
    }

    private int[] rotate(int[] nums, int index) {
        int[] result = new int[nums.length];
        for(int i = index; i < nums.length; i++) {
            result[i - index] = nums[i];
        }
        for (int i = 0; i < index; i++) {
            result[nums.length - index + i ] = nums[i];
        }
        return result;
    }

    @Test(dataProvider = "data")
    public void test(int[] input , int expectedOutPut){
        int actualReslut = new SearchInRotatedArray().findPivot(input, 0, input.length - 1);
        Assert.assertEquals(actualReslut, expectedOutPut);
    }
}
