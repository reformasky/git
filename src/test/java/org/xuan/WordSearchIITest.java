package org.xuan;

import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

/**
 * Created by xzhou2 on 4/15/16.
 */
public class WordSearchIITest {
    @DataProvider(name = "data")
    public Object[][] data() {
        char[][] board = new char[][]{
                new char[]{'o','a','a','n'},
                new char[]{'e','t','a','e'},
                new char[]{'i','h','k','r'},
                new char[]{'i','f','l','v'}
        };

        return new Object[][] {
                {board, new String[]{"oath","pea","eat","rain"}}
        };
    }

    @Test(dataProvider = "data")
    public void test(char[][] board, String[] strings) {
        Assert.assertEquals(new WordSearchII().findWords(board,strings).size(), 2);
    }
}
