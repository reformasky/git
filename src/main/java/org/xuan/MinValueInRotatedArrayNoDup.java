package org.xuan;

/**
 * Created by xzhou2 on 4/3/16.
 */
public class MinValueInRotatedArrayNoDup {
    public int findMin(int[] nums) {
        if (nums == null || nums.length == 0) {
            return 0;
        }
        return findMin(nums, 0, nums.length - 1);
    }

    private int findMin(int[] nums, int low, int high) {
        if (low >= high -1) {
            return Math.min(nums[low], nums[high]);
        }
        int mid = (high - low) /2 + low;
        if (nums[mid] > nums[low] && nums[mid] > nums[high]) {

            return findMin(nums, mid, high);
        }
        else {
            return findMin(nums, low, mid);
        }
    }
}
