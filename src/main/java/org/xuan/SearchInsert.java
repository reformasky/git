package org.xuan;

/**
 * Created by xuan on 2015/11/29.
 */
public class SearchInsert {
    public int searchInsert(int[] nums, int target) {
        if (nums == null || nums.length == 0) {
            return 0;
        }
        return searchInsert(nums, 0, nums.length - 1, target);
    }

    private int searchInsert(int[] nums, int low, int high, int target) {
        if (low == high) {
            return target <= nums[low] ? low : low + 1;
        }
        int mid = (low + high) /2;
        while(low <= high) {
            if (nums[mid] == target) {
                return mid;
            }
            else if (nums[mid] > target) {
                high = mid - 1;
            }
            else {
                low = mid + 1;
            }
            mid = (low + high) /2;
        }
        mid = (low + high) /2;
        return nums[mid] > target ? mid: mid + 1;
    }
}
