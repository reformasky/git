package org.xuan;

import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import java.util.List;

/**
 * Created by xzhou2 on 5/18/16.
 */
public class AddOperatorsTest {
    @DataProvider(name = "data")
    public Object[][] data() {
        return new Object[][] {
/*                {
                        "123", 6, new String[]{"1+2+3", "1*2*3"}
                },*/
/*                {
                        "232", 8, new String[]{"2*3+2", "2+3*2"}
                },*/
                {
                        "105", 5, new String[]{"1*0+5","10-5"}
                },
                {
                        "00", 0, new String[]{"0+0", "0-0", "0*0"}
                },
                {
                        "3456237490", 9191, new String[]{}
                }
        };
    }

    @Test(dataProvider = "data")
    public void test(String num, int target, String[] exp) {
        List<String> act =  new AddOperators().addOperators(num, target);
        Assert.assertEquals(act.size(), exp.length);
        for(String s : exp) {
            Assert.assertTrue(act.contains(s));
        }
    }

}
