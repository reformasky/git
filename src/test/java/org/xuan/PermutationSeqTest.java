package org.xuan;

import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

/**
 * Created by xuan on 2015/12/15.
 */
public class PermutationSeqTest{
    @DataProvider(name = "data")
    public Object[][] data(){
        return new Object[][] {
                {3,2,"132"}
        };
    }

    @Test(dataProvider = "data")
    public void test(int n, int k, String expectedResult) {
        Assert.assertEquals(new PermutationSeq().getPermutation(n,k), expectedResult);
    }
}
