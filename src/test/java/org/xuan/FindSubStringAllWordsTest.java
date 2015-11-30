package org.xuan;

import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import java.util.List;

/**
 * Created by xuan on 2015/11/27.
 */
public class FindSubStringAllWordsTest {
    @DataProvider(name = "data")
    public Object[][] data() {
        return new Object[][]{
              /*  {
                        "barfoofoobarthefoobarman", new String[] {"bar","foo","the"}, new Integer[]{}
                },
                {
                        "barfoothefoobarman", new String[] {"foo","bar"}, new Integer[]{0,9}
                },*/
                {
                        "wordgoodgoodgoodbestword", new String[]{"word","good","best","good"}, new Integer[]{8}
                }
        };
    }

    @Test(dataProvider = "data")
    public void test(String s, String[] words, Integer[] expectedResult) {
        List<Integer> actualResult = new FindSubStringAllWords().findSubstring(s, words);
        Assert.assertEquals(actualResult.size(), expectedResult.length);
        for(Integer i : expectedResult) {
            Assert.assertTrue(actualResult.contains(i));
        }
    }
}
