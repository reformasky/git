package org.xuan;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import java.util.List;

/**
 * Created by xuan on 2015/12/12.
 */
public class PermutationDedupTest {
    @DataProvider(name = "data")
    public Object[][] data(  ){
        return new Object[][] {
                {new int[]{1,2}}
        };
    }

    @Test(dataProvider = "data")
    public void test(int[] input) {
        List<List<Integer>> result = new PermutationDedup().permuteUnique(input);
    }
 }
