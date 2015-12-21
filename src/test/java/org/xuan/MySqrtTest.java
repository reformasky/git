package org.xuan;

import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import java.util.Map;
import java.util.Random;

/**
 * Created by xuan on 2015/12/18.
 */
public class MySqrtTest {
    @Test
    public void test() {
        Random random = new Random();
        for( int i = 0; i < 100000; i++) {
            System.out.println(i);
            int v =  new MySqrt().mySqrt(i);
           // int x = random.nextInt(Integer.MAX_VALUE);
            Assert.assertTrue(Math.sqrt(i) - v <= 1 && Math.sqrt(i) >= v , "value=" + i + " " + v);
        }
    }
}
