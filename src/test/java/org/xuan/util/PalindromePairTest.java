package org.xuan.util;

import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import org.xuan.PalindromePair;

import java.util.List;

/**
 * Created by xzhou2 on 6/11/16.
 */
public class PalindromePairTest {
    @DataProvider(name = "data")
    public Object[][] data() {
        return new Object[][] {
/*                {
                        new String[]{"bat", "tab", "cat"}, 2
                },*/
                {
                        new String[]{"abaa", "ba", "aba", "aaba", "aaaba",""},10
                }
        };
    }

    @Test(dataProvider = "data")
    public void test(String[] words, int size) {
        List<List<Integer>> result = new PalindromePair().palindromePairs(words);
        StringBuilder sb = new StringBuilder();
        for(List<Integer> l : result) {
            sb.append("[");
            sb.append(l.get(0));
            sb.append(",");
            sb.append(l.get(1));
            sb.append("], ");
        }
        System.out.println(sb);
        Assert.assertEquals(result.size(), size);
    }
}
