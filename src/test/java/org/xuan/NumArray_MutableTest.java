package org.xuan;

import org.testng.Assert;
import org.testng.annotations.Test;

/**
 * Created by xzhou2 on 5/25/16.
 */
public class NumArray_MutableTest {


    @Test
    public void test() {
        NumArray_Mutable.NumArray numArray = new NumArray_Mutable.NumArray(new int[]{0,1,2,3,4,5,6,7,8,9,10,11,12,13,14,15,16,17});
        Assert.assertEquals(numArray.sumRange(1, 14), 105);
        numArray.update(1,2);
        Assert.assertEquals(numArray.sumRange(1, 14), 106);
        numArray.update(13,3);
        Assert.assertEquals(numArray.sumRange(1, 14), 96);
        for(int i = 0; i < 18; i++) {
            for(int j = 0; j < 18; j++) {
                numArray.sumRange(i, j);
            }
        }
    }


}
