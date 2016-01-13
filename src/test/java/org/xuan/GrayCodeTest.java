package org.xuan;

import org.testng.annotations.Test;

import java.util.List;

/**
 * Created by xuan on 2016/1/12.
 */
public class GrayCodeTest {
    @Test
    public void test() {
        List<Integer> result = new GrayCode().grayCode(2);
    }
}
