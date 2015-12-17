package org.xuan;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import util.Interval;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by xuan on 2015/12/13.
 */
public class MergeIntervalTest {
    @DataProvider(name = "data")
    public Object[][] data() {
        return new Object[][] {
               // {new int[][]{{1,3},{2,6},{8,10},{15,18}}}
                {new int[][]{{1,4},{2,7}, {5,2}, {7,6}, {3,6}}}
        };
    }

    @Test(dataProvider = "data")
    public void test(int[][] input) {
        List<Interval> intervals = new ArrayList<>(input.length);
        for(int[] i : input) {
            intervals.add(new Interval(i[0], i[1]));
        }
        List<Interval> result = new MergeInterval().merge(intervals);
    }
}
