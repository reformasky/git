package org.xuan;

import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import org.xuan.WildCardMatch;

/**
 * Created by xuan on 2015/12/8.
 */
public class WildeCardMatchTest {
    @DataProvider(name = "data")
    public Object[][] data() {
        return new Object[][] {
                {"abbabaaabbabbaababbabbbbbabbbabbbabaaaaababababbbabababaabba=" +
                        "babaabbbbbbaaaabababbbaabbbbaabbbbababababbaabbaababaabbbaba+" +
                        "bababbbbaaabbbbbabaaaabbababbbbaababaabbababbbbbababbbabaaaaaaaabbbbbaabaaababaaaabb",
                        "**aa*****ba*a*bb**aa*ab****a*aaaaaa***a*aaaa**bbabb*b*b**aaaaaaaaa*a********ba*bbb***a*ba*bb*bb**a*b*bb", false}
        };
    }

    @Test(dataProvider = "data")
    public void test(String s, String p, boolean expectedResult) {
        Assert.assertEquals(new WildCardMatch().isMatch(s, p), expectedResult);
    }
}
