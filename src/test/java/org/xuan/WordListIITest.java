package org.xuan;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * Created by xzhou2 on 3/27/16.
 */
public class WordListIITest {
    @DataProvider(name = "data")
    public Object[][] data() {
        return new Object[][] {
                {
                        "catsanddog", new String[]{"cat","cats","and","sand","dog"}
                }
        };
    }

    @Test(dataProvider = "data")
    public void test(String s, String[] d) {
        Set<String> wordDict = new HashSet<>(d.length);
        for(String word : d) {
            wordDict.add(word);
        }
        List<String> result = new WordBreakII().wordBreak(s, wordDict);
    }
}
