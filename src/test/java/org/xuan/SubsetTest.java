package org.xuan;

import org.testng.annotations.Test;

import java.util.List;

/**
 * Created by xuan on 2015/12/21.
 */
public class SubsetTest {
    @Test
    public void test() {
        List<List<Integer>> result = new SubSets().subsets(new int[] {1,2});
    }
}
