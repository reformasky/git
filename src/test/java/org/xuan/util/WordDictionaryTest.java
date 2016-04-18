package org.xuan.util;

import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import util.WordDictionary;

/**
 * Created by xzhou2 on 4/14/16.
 */
public class WordDictionaryTest {
    WordDictionary wordDictionary;
    String[] input = new String[] {"a", "aba", "abcd","abacd", "zzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzz" +
            "zzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzz" +
            "zzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzz" +
            "zzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzz"};

    @BeforeClass
    public void beforeClass() {

        wordDictionary = new WordDictionary();
        for(String s : input) {
            wordDictionary.addWord(s);
        }
    }


    @DataProvider(name = "data")
    public Object[][] data() {
        return new Object[][] {
                {"", true},
                {"a.a", true},
                {".b..", true},
                {"....d", true},
                {"....e", false},
                {".....", true},
                {"..", false},
                {"......", false},
                {"zzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzz" +
                        "zzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzz" +
                        "zzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzz" +
                        "zzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzz", true},
                {
                        "zzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzz" +
                                "zzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzz" +
                                "zzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzz" +
                                "zzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzu", false
                },
                {
                        "........................................................" +
                                "................................................................................................." +
                                "............................................................................................................" +
                                "...........................................................................................", true
                },
                {
                        "........................................................" +
                                "................................................................................................." +
                                "............................................................................................................" +
                                "........................................z.................................................z", true
                },
                {
                        "........................................................" +
                                "................................................................................................." +
                                "............................................................................................................" +
                                "..........................................................................................y",false
                },
                {
                        "........................................................" +
                                "................................................................................................." +
                                "............................................................................................................" +
                                "..........................................................................................", false
                },
                {
                        "........................................................" +
                                "................................................................................................." +
                                "............................................................................................................" +
                                "............................................................................................", false
                }


        };
    }

    @Test(dataProvider = "data")
    public void test(String s, boolean result) {
        Assert.assertEquals(wordDictionary.search(s), result);
    }
}
