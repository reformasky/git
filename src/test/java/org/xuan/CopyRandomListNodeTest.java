package org.xuan;

import org.testng.Assert;
import org.testng.annotations.Test;
import util.RandomListNode;

/**
 * Created by xzhou2 on 3/27/16.
 */
public class CopyRandomListNodeTest {
    @Test
    public void test() {
        RandomListNode node1 = new RandomListNode(1),
                node2 = new RandomListNode(2),
                node3 = new RandomListNode(3),
                node4 = new RandomListNode(4);
        node1.next = node2;
        node2.next = node3;
        node3.next = node4;

        node1.random = node1;
        node2.random = node4;
        node4.random = node2;

        RandomListNode result = new CopyRandomListNode().copyRandomList(node1);
        Assert.assertEquals(result.label, node1.label);

    }
}
