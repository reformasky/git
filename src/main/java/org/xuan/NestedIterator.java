package org.xuan;

import util.NestedInteger;

import java.util.ArrayList;
import java.util.Deque;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

/**
 * Created by xzhou2 on 6/6/16.
 */
public class NestedIterator implements Iterator<Integer> {

    Deque<Integer> queue;
    public NestedIterator(List<NestedInteger> nestedList) {
        queue = new LinkedList<Integer>();
        Deque<NestedInteger> cache = new LinkedList<NestedInteger>();
        for(NestedInteger n : nestedList) {
            cache.addLast(n);
        }
        while(! cache.isEmpty()) {
            NestedInteger n  = cache.removeFirst();
            if (n.isInteger()) {
                queue.addLast(n.getInteger());
            }
            else {
                List<NestedInteger> list = new ArrayList<>(n.getList());
                for(int i = list.size() - 1; i >= 0; i--) {
                    cache.addFirst(list.get(i));
                }
            }
        }
    }

    @Override
    public Integer next() {
        return queue.removeFirst();
    }

    @Override
    public boolean hasNext() {
        return !queue.isEmpty() ;
    }
}