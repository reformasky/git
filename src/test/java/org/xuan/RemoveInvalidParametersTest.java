package org.xuan;

import junit.framework.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import java.util.List;

/**
 * Created by xzhou2 on 5/24/16.
 */
public class RemoveInvalidParametersTest {
    @DataProvider(name = "data")
    public Object[][] data(){
        return new Object[][] {
                /*{
                        "(abc)d(efgh)i(j", new String[]{"abcd(efgh)ij"}
                },*/
                /*{
                        "(a()b)", new String[]{"(a()b)"}
                }*/
                {
                        "(()", new String[] {"()"}
                }
        };
    }

    @Test(dataProvider = "data")
    public void test(String input, String[] output) {
        List<String> result = new RemoveInvalidParameters().removeInvalidParentheses(input);
        for(String s : output) {
            Assert.assertTrue(result.contains(s));
        }

    }

}
