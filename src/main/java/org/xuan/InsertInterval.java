package org.xuan;

import util.Interval;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by xuan on 2015/12/13.
 */
public class InsertInterval {
    public List<Interval> insert(List<Interval> intervals, Interval newInterval) {
        List<Interval> output = new ArrayList<>();

        boolean added = false; // flag for marking if newInterval is added
        for (Interval in : intervals) {
            if (in.end < newInterval.start) { // left to newInterval
                output.add(in);
            } else if (in.start <= newInterval.end && in.end >= newInterval.start) { // overlapping
                newInterval.start = Math.min(in.start, newInterval.start);
                newInterval.end = Math.max(in.end, newInterval.end);
            } else { // right to newInterval
                if (!added) { // insert the newInterval
                    output.add(newInterval);
                    added = true;
                }
                output.add(in);
            }
        }
        if (!added) output.add(newInterval);

        return output;
    }
}
