package org.xuan;

/**
 * Created by xzhou2 on 4/2/16.
 */
public class FindPeakElement {
    public int findPeakElement(int[] nums) {
        if (nums == null || nums.length ==0) {
            return Integer.MIN_VALUE;
        }
        return findPeakElement(nums, 0, nums.length - 1);
    }

    private int findPeakElement(int[] nums, int low, int high) {
        if (low >= high) {
            return low;
        }
        int mid = low + (high - low) /2;
        boolean left = true, right = true;
        if (mid > 0) {
            left = nums[mid] > nums[mid -1];
        }
        if (mid < nums.length - 1) {
            right = nums[mid] > nums[mid + 1];
        }
        if (left && right) {
            return mid;
        }
        else if (! left) {
            return findPeakElement(nums, low, mid - 1);
        }
        else {
            return findPeakElement(nums, mid + 1, high);
        }

    }
}
