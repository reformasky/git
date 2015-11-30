package org.xuan;

import java.util.Arrays;

/**
 * Created by xuan on 2015/11/29.
 */
public class SearchForRange {
    public int[] searchRange(int[] nums, int target) {
        int left = -1, right = -1;
        if (nums == null || nums.length == 0) {
            return new int[] {left, right};
        }

        int index = Arrays.binarySearch(nums, target);
        if (index < 0) {
            return new int[] {left, right};
        }
        left = index;
        right = index;
        int leftIndex = index;
        int rightIndex = index;
        while(index >= 0) {
            index = Arrays.binarySearch(nums, 0, index, target);
            left = index >= 0 ? index : left;
        }

        while(rightIndex >= 0) {
            rightIndex = Arrays.binarySearch(nums, rightIndex + 1, nums.length , target);
            right = rightIndex >= 0 ? rightIndex : right;
        }

        return new int[]{left, right};
    }
}
