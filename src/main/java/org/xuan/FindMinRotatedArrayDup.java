package org.xuan;

/**
 * Created by xzhou2 on 4/3/16.
 */
public class FindMinRotatedArrayDup {
    public int findMin_ON(int[] nums) {
        if (nums == null || nums.length == 0) {
            return 0;
        }
        return findMin_ON(nums, 0, nums.length - 1);
    }

    private int findMin_ON(int[] nums, int low, int high) {
        if (low >= high - 1) {
            return Math.min(nums[low], nums[high]);
        }
        int mid = low + (high - low) /2;
        if (nums[low] == nums[high]) {
            if (nums[mid] > nums[low]) {
                return findMin_ON(nums, mid, high);
            }
            else if (nums[mid] < nums[low]) {
                return findMin_ON(nums, low, mid);
            }
            return Math.min(findMin_ON(nums, low, mid), findMin_ON(nums, mid + 1, high));
        }
        else {
            if (nums[mid] >= nums[low] && nums[mid] > nums[high]) {
                return findMin_ON(nums, mid, high);
            }
            else {
                return findMin_ON(nums, low, mid);
            }
        }
    }
}
