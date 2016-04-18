package org.xuan;

import org.testng.Assert;
import org.testng.annotations.Test;

/**
 * Created by xzhou2 on 4/13/16.
 */
public class CourseScheduleIITest {
    @Test
    public void test() {
        int n = 2;
        int[][]p = new int[][]{new int[]{1,0}};
        int[] r1 = new CourseScheduleII().findOrder(n, p);
        int[] r2 = new CourseScheduleII().findOrder_1(n, p);
        Assert.assertEquals(r1[1], r2[1]);
    }
}
