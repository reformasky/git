package org.xuan;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import util.Interval;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by xuan on 2015/12/13.
 */
public class InsertIntervalTest {
    @DataProvider(name = "data")
    public Object[][] data() {
        return new Object[][] {
                {new int[][] {{1,4},{5,8}, {9, 13}, {20, 23}}, new int[]{2,14}}
        };
    }

    @Test(dataProvider = "data")
    public void test(int[][] input, int[] inserted) {
        List<Interval> intervals = new ArrayList<>(input.length);
        for(int[] i : input) {
            intervals.add(new Interval(i[0], i[1]));
        }
        List<Interval> result = new InsertInterval().insert(intervals, new Interval(inserted[0], inserted[1]));
    }
}
