package org.xuan;

import java.util.PriorityQueue;

/**
 * Created by xzhou2 on 5/22/16.
 */
public class MedianFinder {
    private PriorityQueue<Integer> left, right;

    public MedianFinder() {
        left = new PriorityQueue<>(1000, (p,q) ->(q - p));
        right = new PriorityQueue<>();
    }

    // Adds a number into the data structure.
    public void addNum(int num) {
        right.offer(num);
        left.offer(right.poll());
        if (right.size() < left.size()) {
            right.offer(left.poll());
        }
    }

    // Returns the median of current data stream
    public double findMedian() {
        if (left.size() == right.size()) {
            return ((double)left.peek() - right.peek()) /2;
        }
        else {
            return (double)right.peek();
        }
    }
}
