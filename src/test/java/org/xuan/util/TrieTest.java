package org.xuan.util;

import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import util.Trie;

/**
 * Created by xzhou2 on 4/13/16.
 */
public class TrieTest {
    @DataProvider(name = "data")
    public Object[][] data() {
        return new Object[][] {
                {new String[]{"abc", "ab", "ac", "abcab"}, new String[]{"abc", "ab", "ac", "abcab", "abca", "ad"}, new boolean[]{true, true, true, true, false, false}, new boolean[]{true, true, true, true, true, false}}
        };
    }

    @Test(dataProvider = "data")
    public void test(String[] add, String[] check, boolean[] exists, boolean[] prefixs){
        Trie trie = new Trie();
        for(String s : add) {
            trie.insert(s);
        }
        for(int i = 0; i < exists.length; i++) {
            Assert.assertEquals(trie.search(check[i]), exists[i]);
        }

        for(int i = 0; i < exists.length; i++) {
            Assert.assertEquals(trie.startsWith(check[i]), prefixs[i]);
        }
    }
}
