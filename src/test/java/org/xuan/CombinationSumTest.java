package org.xuan;

import org.testng.annotations.Test;

import java.util.List;

/**
 * Created by xuan on 2015/12/2.
 */
public class CombinationSumTest {
    @Test
    public void test() {
        List<List<Integer>> result = new CombinationSum().combinationSum(new int[]{1,2,3}, 5);
    }
}
