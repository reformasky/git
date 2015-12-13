package org.xuan;

import java.util.PriorityQueue;

/**
 * Created by xuan on 2015/12/7.
 */
public class TrapWater {
    public int trap(int[] height) {
        if (height == null || height.length <= 1) {
            return 0;
        }
        PriorityQueue<IndexValue> indexValues = new PriorityQueue(height.length);
        for(int i = 0; i < height.length; i++) {
            indexValues.add(new IndexValue(i, height[i]));
        }
        int highest = indexValues.poll().index;
        int left = highest, right = highest;
        int result = 0;

        while(!indexValues.isEmpty() && left >= 0 && right <= height.length) {
            int current = indexValues.poll().index;
            if (current < left) {
                result += trap(height, current, left);
                left = current;
            }
            else if (current > right) {
                result += trap(height, right, current);
                right = current;
            }
        }
        return result;
    }

    private int trap(int[] height, int left, int right) {
        int result = 0;
        int lower = Math.min(height[left], height[right]);
        for(int i = left + 1; i < right; i++) {
            result += lower - height[i];
        }
        return result;
    }


    class IndexValue implements Comparable<IndexValue> {
        int index;
        int value;
        IndexValue(int i, int v) {
            index = i;
            value = v;
        }

        //reverse the order, larger first
        public int compareTo(IndexValue that) {
            return - this.value + that.value;
        }
    }

    public int trap_2 (int[] height) {
        if (height == null || height.length <= 1) {
            return 0;
        }
        int result = 0,left = 0, right = height.length - 1, section = -1;
        while (left < right) {
            if (height[left] < height[right]) {
                section = Math.max(section, height[left]);
                result += section - height[left++];
            }
            else {
                section = Math.max(section, height[right]);
                result += section - height[right--];
            }
        }
        return result;
    }
}
