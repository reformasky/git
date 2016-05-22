package org.xuan;

import org.testng.annotations.Test;

/**
 * Created by xzhou2 on 5/22/16.
 */
public class MedianFinderTest {
    @Test
    public void test() {
        MedianFinder mf = new MedianFinder();
        for(int i : new int[]{1,2,3,4,5,1,2,3,4,5}) {
            mf.addNum(-i);
        }
    }
}
