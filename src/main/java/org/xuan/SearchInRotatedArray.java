package org.xuan;

import java.util.Arrays;

/**
 * Created by xuan on 2015/11/29.
 */
public class SearchInRotatedArray {
    public int search(int[] nums, int target) {
        if (nums == null || nums.length == 0) {
            return -1;
        }
        int pivotIndex = findPivot(nums, 0, nums.length - 1);
        if (nums[0] == target) {
            return 0;
        } else if (nums[0] < target) {
            int index = Arrays.binarySearch(nums, 0, pivotIndex, target);
            return index >= 0 ? index : -1;
        } else {
            int index = Arrays.binarySearch(nums, pivotIndex, nums.length, target);
            return index >= 0 ? index : -1;
        }
    }


    public int findPivot(int[] nums, int low, int high) {
        if (nums[low] < nums[high]) {
            return high + 1;
        }
        int mid = (low + high) / 2;
        //l >= h; && there should be no number i such h < i < l
        while (high - low > 1) {
            if (nums[mid] >= nums[low]) {
                low = mid;
            } else {
                high = mid;
            }
            mid = (low + high) / 2;
        }
        return high;
    }
}
