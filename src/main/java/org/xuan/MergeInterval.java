package org.xuan;

import util.Interval;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

/**
 * Created by xuan on 2015/12/13.
 */
public class MergeInterval {
    class IntervalComparator implements Comparator<Interval> {
        @Override
        public int compare(Interval t0, Interval t1) {
            return t0.start - t1.start;
        }
    }

    class ReverseComparator implements Comparator<Interval> {

        @Override
        public int compare(Interval t0, Interval t1) {
            return t0.end - t1.end;
        }
    }

    public List<Interval> merge(List<Interval> intervals) {
        List<Interval> result = new ArrayList<>();
        if (intervals == null || intervals.size() == 0) {
            return result;
        }
        List<Interval> inOrder = new ArrayList<>();
        List<Interval> reverse = new ArrayList<>();
        for(Interval i : intervals) {
            if (i.start <= i.end) {
                inOrder.add(i);
            }
            else {
                reverse.add(i);
            }
        }
        if (! inOrder.isEmpty()) {
            Interval[] arr = new Interval[inOrder.size()];
            inOrder.toArray(arr);
            Arrays.sort(arr, new IntervalComparator());
            int start = arr[0].start;
            int end = arr[0].end;
            for(int i = 1; i < arr.length; i++) {
                if (arr[i].start > end) {
                    result.add(new Interval(start, end));
                    start = arr[i].start;
                    end = arr[i].end;
                }
                if (arr[i].end > end) {
                    end = arr[i].end;
                }
            }
            result.add(new Interval(start, end));
        }
        if (! reverse.isEmpty()) {
            Interval[] arr = new Interval[reverse.size()];
            reverse.toArray(arr);
            Arrays.sort(arr, new ReverseComparator());
            int start = arr[0].start;
            int end = arr[0].end;
            for(int i = 1; i < arr.length; i++) {
                if (arr[i].end > start ) {
                    result.add(new Interval(start, end));
                    start = arr[i].start;
                    end = arr[i].end;
                }
                if (arr[i].start > start) {
                    start = arr[i].start;
                }
            }
            result.add(new Interval(start, end));
        }

        return result;
    }
}
