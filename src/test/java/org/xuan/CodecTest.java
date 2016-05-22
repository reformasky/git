package org.xuan;

import org.testng.Assert;
import org.testng.annotations.Test;
import util.TreeNode;

/**
 * Created by xzhou2 on 5/22/16.
 */
public class CodecTest {
    @Test
    public void test() {
        String s = "1 2 4 # # 5 # # 3 6 # # # ";
        TreeNode root = new Codec().deserialize(s);
        String s1 = new Codec().serialize(root);
        Assert.assertEquals(s, s1);
    }
}
