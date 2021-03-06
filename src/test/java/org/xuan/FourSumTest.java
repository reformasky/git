package org.xuan;

import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import java.util.*;

/**
 * Created by xuan on 2015/11/22.
 */
public class FourSumTest {
    @DataProvider(name = "data")
    public Object[][] data() {
        return new Object[][] {
              /*  {
                        null, new ArrayList<ArrayList<Integer>>()
                },*/
                {
                        new int[]{1, 0, -1, 0, -2, 2},new ArrayList<ArrayList<Integer>>()
                }
        };
    }

    @Test(dataProvider = "data")
    public void test(int[] input, List<List<Integer>> expectedResult) {
        List<List<Integer>> actualResult = new FourSum().fourSum(input, 0);
    }


    @Test
    public void test() {
        HashMap<String, Integer> map = new HashMap<>();
        map.put("a",2);
        HashMap<String, Integer> copiedMap = (HashMap<String, Integer>) map.clone();
        copiedMap.put("a",1);
        Assert.assertEquals(map.get("2"), (Integer) 2);
    }
}
