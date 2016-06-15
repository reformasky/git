package org.xuan;

import util.Interval;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;

public class SummaryRanges {

    TreeMap<Integer, Interval> map;
    /** Initialize your data structure here. */
    public SummaryRanges() {
        map = new TreeMap<>();
    }

    public void addNum(int val) {
        if (map.containsKey(val)) {
            return;
        }
        Map.Entry<Integer, Interval> left = map.lowerEntry(val),
                right = map.higherEntry(val);
        Interval less = left == null ? null:  left.getValue(),
                more = right == null ? null : right.getValue();

        if (less != null && more!= null && val == less.end+ 1 && val == more.start - 1) {
            map.get(less.start).end = map.get(more.start).end;
            map.remove(more.start);
        }
        else if (less != null && val <= less.end + 1) {
            map.get(less.start).end = Math.max(val, less.end);
        }
        else if (more != null && val == more.start - 1) {
            Interval interval = new Interval(val, more.end);
            map.put(val, interval);
            map.remove(more.start);
        }
        else {
            map.put(val, new Interval(val, val));
        }
    }

    public List<Interval> getIntervals() {
        return new ArrayList<>(map.values());
    }
}