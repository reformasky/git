package org.xuan;

import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import java.util.Arrays;

/**
 * Created by xuan on 2015/12/23.
 */
public class SearchInRotatedSortedArrayTest {
    @DataProvider(name = "data")
    public Object[][] data() {
        int[] array = new int[100];
        int[] array1 = new int[101];
        int[] array2 = new int[100];
        int[] array3 = new int[101];
        for(int i = 0; i < 10; i++) {
            array[100 - i -  1] = 100 - i + 1;
            array1[101 - i - 1] = 101 - i + 1;
        }
        for(int i = 0; i < 9; i++) {
            array2[100 - i - 1] = 100 - i + 1;
            array3[101 - i - 1] = 101 - i + 1;
        }
        return new Object[][] {
/*
                {array, 101},
*/
                {array1, 102}
/*
                , {array2, 101}, {array3, 102}, {new int[100],0 }
*/
        };
    }

    @Test(dataProvider = "data")
    public void test(int[] arr, int v) {
        int[] arr1;
        for(int i = 0; i < arr.length; i++) {
           arr1 = rotateAt(arr,i);
            int p = new SearchInRotatedSortedArray().findPivot(arr1, 0, arr.length - 1);
            if (p < arr.length)
                Assert.assertEquals(arr1[p], v, String.format("i = %d", i));
        }
    }

    @Test
    public void test1() {
        int p = new SearchInRotatedSortedArray().findPivot(new int[] {3,5,1}, 0, 2);
        Assert.assertTrue(new SearchInRotatedSortedArray().search(new int[]{1,1}, 0));
    }

    private int[] rotateAt(int[] nums, int index) {
        int[] result = new int[nums.length];
        for(int i = 0; i < index; i++) {
            result[i] = nums[nums.length  - index + i];
        }
        for(int i = index; i < nums.length; i++) {
            result[i] = nums[i - index];
        }
        return result;
    }
}
