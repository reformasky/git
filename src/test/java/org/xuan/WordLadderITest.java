package org.xuan;

import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * Created by xuan on 2016/3/6.
 */
public class WordLadderITest {
    @DataProvider(name = "data")
    public Object[][] data() {
        return new Object[][] {
                {
                       "hot","dog" , new String[] {"hot","cog","dog","tot","hog","hop","pot","dot"},5
                }
        };
    }

    @Test(dataProvider = "data")
    public void test(String begin, String end, String[] strings, int result) {
        Set<String> wordList = new HashSet<>(Arrays.asList(strings));
       /* Assert.assertEquals(new WordLadderII().findLadders(begin, end,wordList), result);*/
        List<List<String>> actualResult = new WordLadderII().findLadders(begin, end, wordList);
        Assert.assertEquals(actualResult.size(), 2);
    }
}
