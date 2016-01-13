package org.xuan;

import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

/**
 * Created by xuan on 2015/12/22.
 */
public class WordSearchTest {
    @DataProvider(name = "data")
    public Object[][] data() {
       char[][] board =  new char[][] {
                {'A','B','C','E'},
                {'S','F','C','S'},
                {'A','D','E','E'}
       };
        return new Object[][] {
                {board, "ABCCED", true},
                {board, "SEE", true},
/*
                {board,"ABCB", false}
*/
        };
    }

    @Test(dataProvider = "data")
    public void test(char[][] board, String word, boolean expectedResult) {
        boolean actualResult = new WordSearch().exist(board, word);
        Assert.assertEquals(actualResult, expectedResult);
    }
}
