package org.xuan;

import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.List;
import java.util.StringTokenizer;

/**
 * Created by xuan on 2015/12/13.
 */
public class NQueuesTest {
    @Test
    public void test() {
        int n = 8;
        StringBuilder sb = new StringBuilder(n);
        for(int i = 0; i < n; i++) {
            sb.append(i % 10);
        }
       int result = new NQueens_2().solveNQueens(n);
        Assert.assertEquals(result, 92);
    }
}
