package org.xuan;

import java.util.Arrays;

/**
 * Created by xuan on 2015/12/23.
 */
public class SearchInRotatedSortedArray {
    public boolean search(int[] nums, int target) {
        if (nums == null || nums.length == 0) {
            return false;
        }
        if (nums.length == 1) {
            return nums[0] == target;
        }
        int p = findPivot(nums, 0, nums.length - 1);
        if (p >= nums.length) {
            return found(nums, 0, p, target);
        }

        if (nums[0] == target) {
            return true;
        } else if (target > nums[0]) {
            return found(nums, 0, p + 1, target);
        } else {
            return found(nums, p + 1, nums.length, target);
        }
    }

    public boolean found(int[] nums, int low, int high, int target) {
        int index = Arrays.binarySearch(nums, low, high, target);
        if (index >= nums.length || index < 0) {
            return false;
        }
        return nums[index] == target;
    }

    public int findPivot(int[] nums, int low, int high) {
        //No rotation
        if (nums[low] < nums[high]) {
            return high + 1;
        }
        if (high - low <= 1) {
            return nums[high] > nums[low] ? high : low;
        }
        int mid = (low + high) / 2;
        if (nums[mid] > nums[low] || (nums[mid] == nums[low] && nums[mid] > nums[high])) {
            return findPivot(nums, mid, high);
        } else if (nums[mid] < nums[high] || (nums[mid] == nums[high] && nums[mid] < nums[low])) {
            return findPivot(nums, low, mid);
        } else {
            int pL = findPivot(nums, low, mid);
            int pR = findPivot(nums, mid, high);
            if (nums[pL] == nums[mid]) {
                return pR;
            }
            return pL;
        }
    }


    public boolean search_1(int[] nums, int target) {
        if (nums.length == 0 || nums == null)
            return false;
        int low = 0, high = nums.length - 1, mid;
        while (low <= high) {
            mid = low + (high - low) / 2;
            if (nums[mid] == target)
                return true;
            else if (nums[mid] > nums[low]) {
                if (target >= nums[low] && target < nums[mid])
                    high = mid - 1;
                else
                    low = mid + 1;
            } else if (nums[mid] < nums[low]) {
                if (target > nums[mid] && target <= nums[high])
                    low = mid + 1;
                else
                    high = mid - 1;
            } else {
                low++;
            }
        }
        return false;
    }
}
