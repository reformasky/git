package org.xuan;

import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import util.Point;

/**
 * Created by xzhou2 on 3/28/16.
 */
public class MaxPointsOnALineTest {
    @DataProvider(name = "data")
    public Object[][] data() {
        return new Object[][] {
                {new Point[]{new Point(0,-12),new Point(5,2),new Point(2,5),new Point(0,-5),new Point(1,5),new Point(2,-2),new Point(5,-4),new Point(3,4),new Point(-2,4),new Point(-1,4),new Point(0,-5),new Point(0,-8),new Point(-2,-1),new Point(0,-11),new Point(0,-9)}, 5}
        };
    }

    @Test(dataProvider = "data")
    public void test(Point[] points, int result) {
        int actualResult = new MaxPointsOnALine().maxPoints(points);
        Assert.assertEquals(actualResult, result);
    }
}
