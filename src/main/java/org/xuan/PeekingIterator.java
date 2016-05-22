package org.xuan;

import java.util.Iterator;

/**
 * Created by xzhou2 on 5/19/16.
 */
class PeekingIterator implements Iterator<Integer> {
    Integer val;
    Iterator<Integer> iter;

    public PeekingIterator(Iterator<Integer> iterator) {
        // initialize any member here.
        val = null;
        iter = iterator;
    }

    // Returns the next element in the iteration without advancing the iterator.
    public Integer peek() {
        if (!hasNext()) {
            throw new RuntimeException();
        }
        if (val == null) {
            val = iter.next();
        }
        return val;
    }

    // hasNext() and next() should behave the same as in the Iterator interface.
    // Override them if needed.
    @Override
    public Integer next() {
        if (!hasNext()) {
            throw new RuntimeException();
        }
        if (val != null) {
            int result = val;
            val = null;
            return result;
        }

        return iter.next();
    }

    @Override
    public boolean hasNext() {
        return val != null || iter.hasNext();

    }
}