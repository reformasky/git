package org.xuan;

import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.Arrays;
import java.util.Iterator;

/**
 * Created by xzhou2 on 5/19/16.
 */
public class PeekingIteratorTest {


    @Test
    public void test() {
        Iterator<Integer> iterator = Arrays.asList(1,2,3,4,5).iterator();
        PeekingIterator peekingIterator = new PeekingIterator(iterator);
        Assert.assertEquals(peekingIterator.next(), (Integer)1);
        Assert.assertEquals(peekingIterator.peek(), (Integer)2);
        Assert.assertTrue(peekingIterator.hasNext());
        Assert.assertTrue(peekingIterator.next() == 2);
        Assert.assertTrue(peekingIterator.next() == 3);
        Assert.assertTrue(peekingIterator.peek() == 4);
        Assert.assertTrue(peekingIterator.next() == 4);
        Assert.assertTrue(peekingIterator.peek() == 5);
        Assert.assertTrue(peekingIterator.peek() == 5);
        Assert.assertTrue(peekingIterator.next() == 5);
        Assert.assertFalse(peekingIterator.hasNext());
    }
}
