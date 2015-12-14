package org.xuan;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import java.util.List;

/**
 * Created by xuan on 2015/12/13.
 */
public class SpiralMatrixTest {
    @DataProvider(name = "name")
    public Object[][] data(){
        return new Object[][] {
                {new int[][]{{1,2,3}}},
                {new int[][]{{1,2,3},{4,5,6}}},
                {new int[][]{{1,2,3},{4,5,6}, {7,8,9}}},
                {new int[][]{{1,2,3}, {4,5,6},{7,8,9}, {10,11,12}}}

        };
    }

    @Test(dataProvider = "name")
    public void test(int[][] matrix) {
        List<Integer> result = new SpiralMatrix().spiralOrder(matrix);
        for(int i : result) {
            System.out.print( i + " ");
        }
    }
}
